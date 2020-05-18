def solution(A):
    tab = [0] * len(A)
    counter = 0

    for i in range(len(A) - 1, -1, -1):
        if A[i] == 1:
            counter += 1
        tab[i] = counter

    counter_final = 0

    for i in range(len(A)):
        if A[i] == 0:
            counter_final += tab[i]

        if counter_final < 0:
            return -1

    if counter_final <= 1000_000_000:
        return counter_final
    return -1


print(solution([0, 1, 0, 1, 1]))
