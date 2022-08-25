
def main():

    n = int(input('Number of integers to sort: '))
    numbers = []
    for i in range(n):
        number = int(input(f'Enter item {i+1}: '))
        numbers.append(number)
    
    numbers.sort()
    
    for i in range(n):
        print(numbers[i])

if __name__ == "__main__":
    main()
