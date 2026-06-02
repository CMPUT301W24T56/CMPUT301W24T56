from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import get_object_or_404, render
from django.urls import reverse
from django.views import generic
from rest_framework.decorators import api_view
from rest_framework.response import Response

from .models import MultipleChoiceOption, MultipleChoiceQuestion
from .serializers import QuestionSerializer


class IndexView(generic.ListView):
    template_name = "polls/index.html"
    context_object_name = "latest_question_list"

    def get_queryset(self):
        """Return the last five published questions."""
        return MultipleChoiceQuestion.objects.order_by("-pub_date")[:5]
    
class DetailView(generic.DetailView):
    model = MultipleChoiceQuestion
    context_object_name = "question"
    template_name = "polls/detail.html"

class ResultsView(generic.DetailView):
    model = MultipleChoiceQuestion
    context_object_name = "question"
    template_name = "polls/results.html"
    
def vote(request, question_id):
    question = get_object_or_404(MultipleChoiceQuestion, pk=question_id)
    try:
        selected_choice = question.multiplechoiceoption_set.get(pk=request.POST["choice"])
    except (KeyError, MultipleChoiceOption.DoesNotExist):
        # Redisplay the question voting form.
        return render(
            request,
            "polls/detail.html",
            {
                "question": question,
                "error_message": "You didn't select a choice.",
            },
        )
    else:
        selected_choice.votes += 1
        selected_choice.save()
        # Always return an HttpResponseRedirect after successfully dealing
        # with POST data. This prevents data from being posted twice if a
        # user hits the Back button.
        return HttpResponseRedirect(reverse("polls:results", args=(question.id,)))
    
def index(request):
    latest_question_list = MultipleChoiceQuestion.objects.order_by("-pub_date")[:5]
    context = {"latest_question_list": latest_question_list}
    return render(request, "polls/index.html", context)

def detail(request, question_id):
    question = get_object_or_404(MultipleChoiceQuestion, pk=question_id)
    return render(request, "polls/detail.html", {"question": question})
def results(request, question_id):
    question = get_object_or_404(MultipleChoiceQuestion, pk=question_id)
    return render(request, "polls/results.html", {"question": question})

def vote(request, question_id):     # http://localhost:8000/wiki/polls/5/vote/
    return HttpResponse("You're voting on question %s." % question_id)



# We are adding a new API route that lists question data in JSON format!
@api_view(['GET'])
def get_questions(request):
    """
    Get the list of questions on our website
    """
    questions = MultipleChoiceQuestion.objects.all()
    serializer = QuestionSerializer(questions, many=True)
    return Response(serializer.data)

@api_view(['GET','POST'])
def update_question(request, pk):
    """
    Update a specific question
    """
    question = MultipleChoiceQuestion.objects.get(id=pk)
    serializer = QuestionSerializer(question, data=request.data, partial=True)
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data)
    return Response(status=400, data=serializer.errors)