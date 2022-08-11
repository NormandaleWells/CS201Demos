
def main():
    num_to_read = int(input())
    sum = 0
    for _ in range(num_to_read):
        num = int(input())
        sum += num
    print(sum / num_to_read)

if __name__ == "__main__":
    main()
