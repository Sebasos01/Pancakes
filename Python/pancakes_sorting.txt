def pancakes_flip(pancake_stack: list, pos_register: dict, stack_size: int, position: int):
    pos = position
    flip_size = stack_size - position
    upper_limit = flip_size//2 - 1
    step = flip_size - 1
    while pos <= (position + upper_limit):
        pancake_i = pancake_stack[pos]
        pancake_f = pancake_stack[pos + step]
        pancake_stack[pos] = pancake_f
        pancake_stack[pos + step] = pancake_i
        pos_register[pancake_i][0] = pos + step
        pos_register[pancake_f][0] = pos
        step -= 2
        pos += 1

def pancakes_sorting(pancake_stack: list):
    answer = list()
    pos_register = dict()
    stack_size = len(pancake_stack)
    current_pos = 0
    while current_pos < stack_size:
        current_pancake = pancake_stack[current_pos]
        correct_position = stack_size - current_pancake
        pos_register[current_pancake] = [current_pos, correct_position]
        current_pos +=1
    pos_i = 0
    for pancake in range(1, stack_size + 1)[::-1]:
        if pos_register[pancake][0] != pos_register[pancake][1]:
            if pos_register[pancake][0] < (stack_size - 1):
                pos_max = pos_register[pancake][0]
                pancakes_flip(pancake_stack, pos_register, stack_size, pos_max)
                answer.append(pos_max)
            pancakes_flip(pancake_stack, pos_register, stack_size, pos_i)
            answer.append(pos_i)
        pos_i += 1
    if len(answer) == 0:
        return "ODERNADO"
    else:
        return answer

def main():
    try:
        n_pancakes = int(input())
        stacks = list()
        i = 1
        while i <= n_pancakes:
            stack = input()
            stack = stack.strip().split(" ")
            j = 0
            while j < len(stack):
                stack[j] = int(stack[j])
                j += 1
            stacks.append(stack)
            i +=1
        print("\n")
        for stack in stacks:
            print(pancakes_sorting(stack))
    except:
        print("Input inválido")

if __name__ == '__main__':
    main()
