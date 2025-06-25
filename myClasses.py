import random
from colorama import Fore,init
init()

class Arena:
    def __init__(self):
        self.displayMap = [["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"],["#","#","#","#","#","#","#"]]
        self.colourMap = [["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"]]

    def initiateColours(self):
        for i in range(5):
            x = random.randint(0,6)
            y = random.randint(0,6)
            for j in range(random.randint(4,8)):
                self.colourMap[y][x] = "G"
                moved = False
                turn = random.randint(0,3)
                while not moved:
                    moved = True 
                    if turn == 0 and y != 0: y -= 1
                    elif turn == 1 and x != 6: x += 1
                    elif turn == 2 and y != 6: y += 1
                    elif turn == 3 and x != 0: x -= 1
                    else: 
                        turn = random.randint(0,3)
                        moved = False
    
    def showMap(self):
        for i in range(6):
          for j in range(6):
              if self.colourMap[i][j] == "Y":
                  print(Fore.YELLOW + self.displayMap[i][j], end = " ")
              else: 
                  print(Fore.GREEN + self.displayMap[i][j], end = " ")
          print("\n")
              
    
    

            
           
              
        

