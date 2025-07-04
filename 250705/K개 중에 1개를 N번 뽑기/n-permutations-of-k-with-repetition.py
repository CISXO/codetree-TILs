K, N = map(int, input().split())
if not (1 < K < 5) or not (1 < N < 5):
    print("K와 N은 1보다 크고 5보다 작은 값을 입력해야 합니다.")
    exit()
answer = []

def choose(curr_num):
    if curr_num == N:
        print(*answer)
        return

    for select in range(1,K+1):
        answer.append(select)
        choose(curr_num + 1)
        answer.pop()

choose(0)
