def solution(N, A):
    max = 0
    for i in A:
        if max < i:
            max = i

    B = [0] * (N)
    max_in_b = 1
    for i in A:
        print(max_in_b)
        if i == max:
            increment_all(max_in_b, B)
        else:
            increment(i - 1, B)
            if max_in_b < B[i - 1]:
                max_in_b = B[i - 1]

    return B


def increment(X, B):
    # print(str(X)+"    "+str(B[X-1]))
    B[X] = B[X] + 1


def increment_all(max_in, B):
    for i in range(len(B)):
        B[i] = max_in
    print(str(B))


print(solution(5, [3, 4, 4, 6, 1, 4, 4]))
