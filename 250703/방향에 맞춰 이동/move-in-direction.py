n = int(input())
moves = [tuple(input().split()) for _ in range(n)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

# Please write your code here

#변수정의(위치,dx,dy,x,y)

x,y=0,0

dx=[1,-1,0,0] #동서남북 
dy=[0,0,-1,1]


n=int(input())



for _ in range(n):
    #각 방향에 따라서 변화하는 x,y정의

    dir,iter=tuple(input().split())
    iter=int(iter)

    if(dir=='W'):  
        dirnum=1
    elif(dir=='S'):
        dirnum=2
    elif(dir=='N'):
        dirnum=3
    else:
        dirnum=4

    x+=dx[dirnum]*iter
    y+=dy[dirnum]*iter

print(x,y)