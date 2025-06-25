from colorama import init, Fore
import random
import myClasses
init()

def startUp():

    valid = False
    while not valid:
      tributeNumber = input("Do you want to have 4 or 8 tributes?: ")
      if tributeNumber not in ("4","8"):
         print("4 and 8 are the only valid inputs")
      else:
         valid = True
         tributeNumber = int(tributeNumber)
    
    if tributeNumber == 4:
      valid = False
      tributeNames = ["Tribute1","Tribute2","Tribute3","Tribute4"]
      print("")
      for i in range(4):
        print(tributeNames[i])
      print("\nThese are the current tribute names\nIf you would like to change them, enter your preferred names as a comma separated list")
      print("e.g: Matthew, Mark, Luke, John")
      print("If you are happy with the current names, enter 'y'")
      while not valid:
        thisInput = input("")
        if thisInput == "y":
            valid = True
        else:
           try:
            thisInput = thisInput.replace(" ","")
            thisInput = thisInput.split(",")
            if len(thisInput) == 4:
               valid = True
               tributeNames = thisInput
            else: 
               print("Try again, this is not a valid input")
           except:
              print("Try again, this is not a valid input")

    print("\nThese are the tributes: ")
    for name in tributeNames:
       print(name)

def event():
  arena = myClasses.Arena()
  arena.initiateColours()
  arena.showMap()

event()