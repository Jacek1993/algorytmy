def solution(S, P, Q):
    genoms = [[0 for x in range(len(S) + 1)] for y in range(3)]
    a = 0
    c = 0
    g = 0

    for i in range(len(S)):
        a = 0
        c = 0
        g = 0
        if 'A' == S[i]:
            a = 1
        if 'C' == S[i]:
            c = 1
        if 'G' == S[i]:
            g = 1
        genoms[0][i + 1] = genoms[0][i] + a
        genoms[1][i + 1] = genoms[1][i] + c
        genoms[2][i + 1] = genoms[2][i] + g

    result = [0 for x in range(len(P))]

    for i in range(len(P)):
        from_index = P[i] + 1
        to_index = Q[i] + 1

        if genoms[0][to_index] - genoms[0][from_index - 1] > 0:
            result[i] = 1
        elif genoms[1][to_index] - genoms[1][from_index - 1] > 0:
            result[i] = 2
        elif genoms[2][to_index] - genoms[2][from_index - 1] > 0:
            result[i] = 3
        else:
            result[i] = 4

    return result


print(solution("CAGCCTA", [2, 5, 0], [4, 5, 6]))
