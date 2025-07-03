
x,y=0,0

dx=[1,-1,0,0] #동서남북 
dy=[0,0,-1,1]


n=int(input())



for _ in range(n):
    #각 방향에 따라서 변화하는 x,y정의

    dir,iter=tuple(input().split())
    iter=int(iter)

    if(dir=='E'):  
        dirnum=0
    elif(dir=='W'):
        dirnum=1
    elif(dir=='S'):
        dirnum=2
    else:
        dirnum=3

    x+=dx[dirnum]*iter
    y+=dy[dirnum]*iter

print(x,y)