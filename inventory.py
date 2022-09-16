#-----------------------------------------------------------------------------
#Capstone Project IV
#Compulsory Task 
#References:
#1. PDF(SE L1T29 - Capstone Project IV - OOP)
#2   Codegrepper.com. 2022. get string until character python Code Example.
#   [online] Available at: <https://www.codegrepper.com/code-examples/python
#   /get+string+until+character+python> [Accessed 16 August 2022].
#3. PDF L1T04 (Additional reading pdf
#4. Au-Yeung, J., 2022. How to edit specific line in text file in Python? -
#   The Web Dev. [online] The Web Dev. Available at:
#   <https://thewebdev.info/2022/04/15/how-to-edit-specific-line-in-text-
#   file-in-python/> [Accessed 17 August 2022].
#5. Soularis, A., 2022. Learn How to Use the __gt__() Method in Python.
#   [online] Medium.com. Available at:<https://python.plainenglish.io/
#   learn-how-to-use-gt-method-in-python-834e0b6bcd10>
#   [Accessed 16 August 2022]
#-----------------------------------------------------------------------------

shoe_list = list()  # Stores a list of shoe objects
headers = list()  # Stores the column headers of the shoe object list

# Stores the file name of the text file used to enter inventory data.
filename_list = ['']

#--------------Class Definition------------------#
class Shoe:
    '''
    A class to represent the stocktaking data for a particular shoe at a
    warehouse

    Attributes
    ----------
    country : str
        country name
    code : str
        shoe code
    product : str
        name of the product(shoe)
    cost : float
        cost of one item of the product(shoe)
    quantity : int
        quantity of product available on stock

    Methods
    -------
    get_cost():
        returns cost
        
    get_quantity():
        returns quantity

    get_quanty():
        return quantity
    
    set_quanty(new_quantity):
        quantity = new_quantity
    '''

    # Constructor func initialises all class attributes to user input values
    def __init__(self, country, code, product, cost, quantity):
        self.country = country
        self.code = code
        self.product = product
        self.cost = cost
        self.quantity = (quantity)

    # Magic func to return a string representation of the class
    def __str__(self):      
        return f'{self.country:<15}{self.code:<10}{self.product:<22}\
{self.cost:<10}{self.quantity:<4}'

    # Magic function allows us to compare objects based on stock quantity
    def __gt__(self, other):
        if isinstance(other, Shoe):
            return self.quantity > other.quantity       

    
    def get_cost(self):
        '''This method returns the cost of a shoe'''
        return self.cost

    def get_quanty(self):
        '''This method returns the quantity of shoes in stock'''    
        return self.quantity
    
    def set_quanty(self, new_quantity):
        '''This method changes quantity attribute to user supplied value'''

        self.quantity = new_quantity

#----------End Of Class Definition----------#
    
#----------Function Definition--------------#         
    
def read_shoes_data():
    '''
    Opens an input file, reads data from it & creates a shoe object based on
    the input data
    '''
    
    print('''---------------------
File Shoe Data Entry |
---------------------
In this section, you will have to provide us with the name of the text file
containing all the shoe inventory data.
''')

    while True:     
        # Ensures that the input file does exist

        filename = input('''Please enter the name of your inventory text \
file:
  ''')
        filename_list[0] = filename
        try:
            inventory_data = open(filename, 'r')

            for index, line in enumerate(inventory_data.readlines(),
                                         start = 0):
                shoe_data = line.strip().split(',')
                
                if index != 0:
                    shoe_object = Shoe(
                                       shoe_data[0],
                                       shoe_data[1],
                                       shoe_data[2],
                                       float (shoe_data[3]),
                                       int(shoe_data[4]),
                                       )
                    
                    shoe_list.append(shoe_object)
                else:
                    if headers == []:
                        shoe_object = Shoe(
                                           shoe_data[0],
                                           shoe_data[1],
                                           shoe_data[2],
                                           shoe_data[3],
                                           shoe_data[4],
                                           )
                        
                        headers.append(shoe_object)
                        
            print('The file has been succesfully read in!')
            main()

        # Executes whenever an input file does not exist
        # Prints out an appropriate error message &  
        except FileNotFoundError as error:
            print(error)
            print('The file that you are trying to open does not exist.')
            
            while True:
                error_handle = input('''\nPlease select an option from below \
to continue:
t  - Please check for any typos & try to enter the file name again...
c  - Go back to the capture menu & select another capture option.
m  - Go back to the main menu
  ''').lower()
            
                if error_handle == 't':
                    read_shoes_data()

                elif error_handle == 'c':
                    capture_menu()

                elif error_handle == 'm':
                    main()

                else:
                     print('That is not a valid option, try again...\n')


def capture_shoes():
    '''Takes in shoe shoe data values via keyboard & creates a shoe object'''
    
    print('''-----------------------
Manual Shoe Data Entry |
-----------------------
Welcome to the product(Shoe) capturing section of the inventory program.
Please follow the prompts & enter product data as requested:
''')
    country = input('''Enter the shoe's country of origin:\n ''')
    code = input('Please enter the product code:\n ')
    product = input('Please enter the name(brand) of the shoe:\n ')
    cost = int(input('Please enter the cost of the shoe:\n '))
    quantity = int(input('Please enter the number of shoes in stock:\n '))

    shoe_object = Shoe(country, code, product, cost, quantity)
    shoe_list.append(shoe_object)

    if headers == []:
        header_object = Shoe('Country','Code','Product','Cost','Quantity')
        headers.append(header_object)

    print('Shoe list updated!')
    
def view_all():
    '''Prints all the shoe stock details stored in the shoe list(database)'''
    
    for header in headers:
        print(header)
    for shoe in shoe_list:
        print(shoe)

def re_stock():
    '''
    Finds the shoe with the lowest stock count & gives user option to reup
    its stock
    '''
    
    if shoe_list != []:
        # Finds the shoe with the lowest stock count
        min_list = sorted(shoe_list)
        print(f'The {min_list[0].product} brand with only \
{min_list[0].get_quanty()} shoes in stock has the lowest\nnumber of shoes \
in stock.\n')

        # Gives user the option to add shoes into the show with lowest stock
        user_choice = input('''Do you want to add more shoes to its stock?
Select an option from below:
y - yes
n - no
: ''').lower()

        # Executes if the user chooses to add more shoes into stock of a shoe
        if user_choice == 'y':
            add_quantity = int(input('Enter the number of shoes you want \
to add: '))
            new_qty =  int(min_list[0].get_quanty()) + add_quantity
            min_list[0].set_quanty(new_qty)

            try:
                with open(filename_list[0], 'r') as file:
                    data = file.readlines()

                
                for index,line in enumerate(data, start = 0):
                    # Split the string on ',' & return the index 1 part(code)
                    if line.split(',')[1] == min_list[0].code:
                        if index + 1 == len(data):
                            data[index] = f'''{line.split(',')[0]},\
{line.split(',')[1]},{line.split(',')[2]},{line.split(',')[3]},{new_qty}'''

                        else:
                            data[index] = f'''{line.split(',')[0]},\
{line.split(',')[1]},{line.split(',')[2]},{line.split(',')[3]},{new_qty}\n'''

                with open(filename_list[0], 'w') as file:
                    file.writelines(data)
                    
            except FileNotFoundError as error:
                print('''The file that you are trying to open does not \
exist.
Please check for any typos & try again ... ''')
                print(error)

        elif user_choice == 'n':
            main()
        
        else:
            print('That is not a valid option, Try again... \n')
            re_stock()
            
    else:  # Empty list error handling
        print('The Shoe database is empty, please capture some items into \
the database\n before trying this action')
        
def search_shoe(shoe_code):
    '''Searches for a shoe from shoe_list & returns the Shoe object foud'''
    if shoe_list != []:
        for shoe in shoe_list:
            shoe_count = 0
            if shoe_code == shoe.code:
                print(headers[0])
                shoe_count += 1
                return print(shoe)

        if shoe_count == 0:
            print("We have no shoe with that code listed in our database\
\n")

    else:  # Empty list error handling
        print('The Shoe database is empty, please capture some items into \
the database\n before trying this action')

def value_per_item():
    '''
    Calculates the total value for each shoe item

    value = cost * quantity
    '''
    
    if shoe_list != []:
        print(f'{headers[0].product:<22} Value')
        for shoe in shoe_list:
            shoe_value = shoe.get_cost() * shoe.get_quanty()
            print(f'{shoe.product:<22} {shoe_value}')

    else:  # Empty list error handling
        print('The Shoe database is empty, please capture some items into \
the database\n before trying this action')

def highest_qty():
    '''Searches for a shoe with the highest quantity & prints it to screen'''
    
    if shoe_list != []:
        sorted_shoes = sorted(shoe_list)
        print(f'The {sorted_shoes[-1].product} is now on sale!!!')

    else:  # Empty list error handling
        print('The Shoe database is empty, please capture some items into \
the database\n before trying this action')
        
def capture_menu():
    '''Gives the user options on how to capture data & create shoe objects'''
    
    capture_choice = input(f'''--------------------
Data Capture Options:
--------------------
Please choose one of these data capture methods:
k  - Manual entry through keyboard
t  - Text file entry
m  - Main Menu
:  ''')

    if capture_choice == 'k':
        capture_shoes()

    elif capture_choice == 't':
        read_shoes_data()

    elif capture_choice == 'm':
        main()

    else:
        print('That is not a valid option.')
        capture_menu()

def main():
    print('''------------------------------
Welcome To The Nike Warehouse |
------------------------------
''')

    while True:
        menu_choice = input('''----------
Main Menu |
----------
Please Select One Of The Options Below:
c  - capture stock product(shoes)item/s.
va - Show all the details of each captured shoe brand on stock
s  - Search a product
r  - Restock a product with lowest quantity
q  - Show the product on sale
v  - Show the stock value of each product(shoe)
e  - Exit program
:  ''').lower()

        if menu_choice == 'c':
            capture_menu()

        elif menu_choice == 'va':           
            view_all()

        elif menu_choice == 's':
            if shoe_list != []:
                    shoe_code = input('Please enter the code of a shoe you want to see\
:\n  ')
                    search_shoe(shoe_code)
                    
            else:  # Empty list error handling
                print('The Shoe database is empty, please capture some items into \
the database\n before trying this action')

        elif menu_choice == 'r':
            re_stock()

        elif menu_choice == 'q':
            highest_qty()

        elif menu_choice == 'v':
            value_per_item()

        elif menu_choice == 'e':
            exit()

        else:
            print('That is not a valid entry, please look at the available \
options & try again.')

#----------End Of Function Definition--------------#

# Start of the program
# Presents the main menu to the user.
main()

