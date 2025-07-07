import random
from colorama import Fore,init
init()

with open("trib_actions.txt","r") as file:
    lines = [line.strip() for line in file]

print(lines)

class Arena:
    def __init__(self,display_map):
        self.display_map = display_map
        self.colour_map = [["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"],["Y","Y","Y","Y","Y","Y","Y"]]

    def initiateColours(self):
        for i in range(5):
            x = random.randint(0,6)
            y = random.randint(0,6)
            for j in range(random.randint(4,8)):
                self.colour_map[y][x] = "G"
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
        for i in range(7):
          for j in range(7):
              if self.colour_map[i][j] == "Y":
                  print(Fore.WHITE + self.display_map[i][j], end = "   ")
              else: 
                  print(Fore.GREEN + self.display_map[i][j], end = "   ")
          print("\n")      

    def move_tribute(self,prev_pos,new_pos,number):
        self.display_map[prev_pos[0]][prev_pos[1]]  = "#"
        self.display_map[new_pos[0]][new_pos[1]] = str(number)

    def fight_update(self, pos, number):
        self.display_map[pos[0]][pos[1]]  = str(number)


class Tribute:
    def __init__(self, position, name, number):
        self.position = position
        self.name = name
        self.number = number

    def move(self, positions, arena):

        moved = False
        new_pos = self.position.copy()

        while not moved:
          direction = random.randint(0,4)

          if direction == 0 and self.position[0] != 0:
              new_pos[0] -= 1
              positions[self.number-1] = new_pos
              moved = True

          if direction == 1 and self.position[1] != 6:
              new_pos[1] += 1
              positions[self.number-1] = new_pos
              moved = True

          if direction == 2 and self.position[0] != 6:
              new_pos[0] += 1
              positions[self.number-1] = new_pos
              moved = True

          if direction == 3 and self.position[1] != 0:
              new_pos[1] -= 1
              positions[self.number-1] = new_pos
              moved = True

          if direction == 4:
              moved = True

          arena.move_tribute(self.position, new_pos, self.number)
          self.position = new_pos

          if positions.count(new_pos) == 2:
              return "fight", new_pos

          else:
              if arena.colour_map[new_pos[0]][new_pos[1]] == "G":
                  message = lines[5 + direction].replace("Tribute",self.name)
              else:
                  message = lines[-1 + direction].replace("Tribute",self.name)

              print(message)
              return "N", positions
          
              
           

                  
                  
                  

              




            
           
              
        

