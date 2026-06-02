from datetime import datetime

from django.db import models


class MultipleChoiceQuestion(models.Model):
    question_text = models.CharField(max_length=200)    # Store the question in a char field in the database
    pub_date = models.DateTimeField("date published", default=datetime.now)   # Store the published date in a datetime field in the database

class MultipleChoiceOption(models.Model):
    question = models.ForeignKey(MultipleChoiceQuestion, on_delete=models.CASCADE)  # All multiple choice options belong to a multiple choice question
    choice_text = models.CharField(max_length=200)  # Store the text for this option in the database
    votes = models.IntegerField(default=0)          # Store the amount of votes this choice has received