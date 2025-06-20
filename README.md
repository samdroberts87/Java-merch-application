Java – Merch app

![CI](https://github.com/samdroberts87/Java-merch-application/actions/workflows/CI.yml/badge.svg)

------------------------------------------------------------------------------------------------------------------------------------
This application is about creating a Console Application which tracks the
details of the merchandising partners. The merchandising Partners are
Customers and Suppliers that the current business organization transacts
with. You need to add and view the details of the existing Customers as well
as the Suppliers.

This was done as a way to show my core java understanding.

### In addition to the below instructions, I've packaged the jar with maven, built the image with docker and scanned the image for vulnerabilities with trivy in a CI pipeline with GitHub actions.

Instructions are as follows:

- Create application with proper packages namely:
  com.merchandise.entities, com.merchandise.services, and
  com.merchandise.consolepack

- Add a class “Merchandise” with partnerId, partnerName, City, State
  properties. Also, add 2 derived classes “Customer” and “Supplier”.

- Next add these additional Properties in respective classes:
  For Customer class: creditLimit, phoneNumber, email
  For Supplier class: CreditBalance, DrivingLicenseNumber

- Property Validation Requirements:
  partnerId: Mandatory and Non-Negative
  partnerName: Mandatory and Minimum 5 characters in length
  City & State: Mandatory and Minimum 3 characters in length
  CreditLimit: Not Beyond 50,000
  PhoneNumber: 10 digits
  Email: proper format
  CreditBalance: Not Beyond 1,75,000
  DrivingLicenseNumber: Proper Format

- Declare function in Merchandise class:
  public String[] Validate(): It will return error messages as per validation
  failures in form of string array.
- Override the virtual Validate function in derived concrete classes to add
  validation logic.
- Add proper methods in all classes for printing information in proper format.
- Create a service class in proper package and add following methods in it.

- i. Public void SaveCustomerDetails(Customer cust): which saves the
  customer details to an array.
  ii. Public List<Customer> GetAllCustomers(): Gets and returns all the
  Customer details from the array.
  iii. Public Customer GetCustomerById(int customerid): Gets and returns the
  Customer details from the array based on id.
  iv. Iv Public void SaveSupplierDetails(Supplier supp): which saves the
  Supplier details to the array.
  v. Public List<Supplier> GetAllSuppliers(): Gets and returns all the Supplier
  details from the array.

- i. Create a single-entry point to the application in consolepack package and do
  the following:
  i. Show a console menu to user using loop as per options below and
  perform as per the user selection of menu until user selects exit menu
  option.
  a. Add Customer – Add object to array based on validation
  b. Add Supplier – Add object to array based on validation
  c. Display Report
  i. Customers – Display all Customer Details
  ii. Suppliers – Display all Supplier Details
  d. Search
  e. Exit

Use proper access specifiers.
Limit array to 5 items.
Apply object-oriented principles.
Make assumptions wherever required, however basic functionality should
not be changed.
