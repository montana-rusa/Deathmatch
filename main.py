from colorama import init, Fore
import random
import my_classes
init()

def startUp():

    valid = False
    while not valid:
      tribute_number = input(Fore.RESET + "Do you want to have 4 or 8 tributes?: ")
      if tribute_number not in ("4","8"):
         print("4 and 8 are the only valid inputs")
      else:
         valid = True
         tribute_number = int(tribute_number)
    print("\nThese are the current tribute names:")
    if tribute_number == 4:
      valid = False
      tribute_names = ["Tribute1","Tribute2","Tribute3","Tribute4"]
      for i in range(4):
        print(tribute_names[i])
      print("\nIf you would like to change them, enter your preferred names as a comma separated list")
      print("e.g: Matthew, Mark, Luke, John")
      print("If you are happy with the current names, enter 'y'")
      while not valid:
        this_input = input("")
        if this_input == "y":
            valid = True
        else:
           try:
            this_input = this_input.replace(" ","")
            this_input = this_input.split(",")
            if len(this_input) == 4:
               valid = True
               tribute_names = this_input
            else: 
               print("Try again, this is not a valid input")
           except:
              print("Try again, this is not a valid input")

    print("\nThese are the tributes: ")

    for i in range(len(tribute_names)):
       print(str(i+1) + ". " + tribute_names[i])
    print("")
    return tribute_number, tribute_names

def event(n):
  if n == 4:
    display_map = [["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"],["#","#","#","1","#","#","#"],["#","#","2","#","4","#","#"],["#","#","#","3","#","#","#"],["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"]]
    arena = my_classes.Arena(display_map)
    arena.initiateColours()
    arena.showMap()
    return arena

tribute_number, tribute_names = startUp()
if tribute_number == 4:
   positions = [[2,3],[3,2],[4,3],[3,4]]

   tributes = {}
   tributes["trib_1"] = my_classes.Tribute(positions[0],tribute_names[0],1)
   tributes["trib_2"] = my_classes.Tribute(positions[1],tribute_names[1],2)
   tributes["trib_3"] = my_classes.Tribute(positions[2],tribute_names[2],3)
   tributes["trib_4"] = my_classes.Tribute(positions[3],tribute_names[3],4)

   Dead = [False,False,False,False]
   print("This is the arena:\n")
   arena = event(4)

   print(Fore.RESET + "\nRemember:\n" + Fore.WHITE + "WHITE = Fields\n"+ Fore.GREEN + "GREEN = Forest\n")

   tributes["trib_1"].move(positions, arena)
   arena.showMap()

