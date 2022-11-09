
import sys


def strip_quotes(s):
    return s[1:-1]


def read_population_data():
    state_data = {}
    in_file = open("StatePopulationData.csv")
    line = in_file.readline()
    for line in in_file:
        fields = line.split(",")
        state = strip_quotes(fields[1])
        population = strip_quotes(fields[2])
        density = strip_quotes(fields[8])
        state_data[state] = (population, density)
    return state_data

def main():
    state_data = read_population_data()
    while (True):
        print("Enter state name (or 'end' to exit")
        state_name = input()
        if state_name == "end": break
        if not state_name in state_data:
            print(f"{state_name} is not in the dictionary")
        else:
            data = state_data[state_name]
            print(f"For {state_name}: Population = {data[0]}, Density = {data[1]}")


if __name__ == "__main__":
    main()
