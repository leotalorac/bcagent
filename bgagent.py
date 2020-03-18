import random
def main():
    bca = bgagent()
    while True:
        b,c = list(map(int,input().split()));
        act = bca.calculate(b,c)
        print(act)
class bgagent:
    possibles = set()
    actual = ""
    prev = ""
    state = "started"
    def __init__(self):
        for i in range(0,10000):
            ns = str(i)
            if(len(ns) ==3):
                ns = "0"+ns
            if(len(set(list(ns))) == 4):
                self.possibles.add(ns)
        self.actual = random.choice(list(self.possibles))
        print("posibles " + str(len(self.possibles)))
        self.prev = self.actual
    def calculate(self,b,c):
        if(b==-1 and c==-1):
            self.state = "computing"
            return self.actual
        if(b==4 and c==0):
            self.state="done"
            return "done! - no operation"
        elif(self.state == "computing"):
            for i in list(self.possibles):
                tembc = self.getbullandcows(i)
                if(tembc[0] != b or tembc[1]!=c):
                    self.possibles.remove(i)
            print(len(self.possibles))     
            self.prev = self.actual   
            self.actual = random.choice(list(self.possibles))
            while(self.prev == self.actual):
                self.actual = random.choice(list(self.possibles))
            return self.actual
        else:
            return "no operation"
    def getbullandcows(self,guess):
        ans = [0,0]
        for i in range(len(guess)):
            for j in range(len(guess)):
                if(self.actual[i] == guess[j]):
                    if(i == j):
                        ans[0] = ans[0]+1
                    else:
                        ans[1] = ans[1]+1
        return ans
if __name__ == "__main__":
    main()