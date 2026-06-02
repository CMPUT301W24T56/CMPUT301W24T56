animal_babies = {
    "hippo": "calf",
    "horse": "foal",
    "dog": "pup",
    "kangaroo": "joey",
    "monkey": "infant",
    "owl": "owlet",
    "parrot": "chick",
    "rabbit": "bunny",
    "rat": "pup",
    "cow": "calf",
    "skunk": "kit",
    "sheep": "lamb"
}

def get_baby_name(animal):
    return animal_babies.get(animal.lower(), "The animal is not on the list.")
animal = input("enter the input ")
print(f"The baby of a {animal} is called a {get_baby_name(animal)}.")
