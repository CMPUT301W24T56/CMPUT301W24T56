"""
URL configuration for lab3 project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import include, path

# this urlpatterns is different from the polls urlpatterns because lab3 is a project rather than an app. 
# This urls.py is the base and forwards requests to the urls.py of the applications
urlpatterns = [
    path("polls/", include("polls.urls")),  # All requests sent to polls/ should be handled by polls/urls.py
    path("admin/", admin.site.urls),    # Django has a built in admin panel we will use later
]