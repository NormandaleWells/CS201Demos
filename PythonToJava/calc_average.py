
def main():
    values = [2.7, 8.2, 4.1, 12.4, 6.2, 3.1, 9.4]
    sum = 0.0
    for value in values:
        sum += value
    average = sum / len(values)
    print(f'Number of values: {len(values)}')
    print(f'Average value: {average}')

if __name__ == "__main__":
    main()
