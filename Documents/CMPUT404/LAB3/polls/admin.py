from django.contrib import admin

from .models import MultipleChoiceOption, MultipleChoiceQuestion

# These lines register your models with the django admin panel. If you do not include these lines, the data associated with these models will not be visible in your admin panel!
admin.site.register(MultipleChoiceQuestion)
admin.site.register(MultipleChoiceOption)