# PatientSkyDeveloperTest

## Solution
The solution provided is for a program that finds available times for a meeting among several participants, given their calendar data.

- **Parsing JSON Data**: The program starts by parsing calendar data from JSON files using the Jackson library's ObjectMapper. The parseJsonData() method reads the JSON data and maps it to Java objects, storing the calendar information for each participant.
- **Finding Available Time**: The core functionality revolves around finding available time slots for the meeting. This is typically done by iterating over the calendars of each participant, checking for overlapping appointments and time slots, and identifying the gaps where the meeting can be scheduled.
- **Filtering by Duration and Time Interval**: The program filters available time slots based on the required meeting duration and the specified time interval. It ensures that the available slots meet the criteria specified by the user.
Optional Feature: Time Slot Type Filtering: An additional feature allows filtering available time slots based on a specific time slot type. This involves passing a time slot type ID as an argument and considering only the time slots that match this type.
- **Output Formatting**: After finding the available time slots, the program formats the output to display the available times for each participant. This may involve printing the calendar ID along with the array of available time slots.
- **Date and Time Handling**: Date and time parsing and manipulation are done using Java's LocalDateTime class and DateTimeFormatter. This ensures that the program can handle date and time data accurately.


Overall, the solution demonstrates how to effectively parse calendar data, find available time slots, and format the output for the user. It leverages Java's libraries and features to implement the required functionality in an efficient and organized manner.

## Design
The Entities are: 
1. Calendar
2. Appointement
3. TimeSlot
4. TimeSlotType
   
- All these Entites are represented with their fields in the package **model**.
- The getters and setters are automatically generated using the @Data annotation.
-  A Calendar uniquely represents a user, there is a one to one relationship, however for the simplicity, relationship is not established between any of these Entities.
-  A Calendar can have many appointments, so there is one to many relationship.
-  An Appointment has one to one relationship with TimeSlot.
-  A time slot has one to one relationship with timeslot TimSlotType.
-  A package **service** is added to add the logic for the solution. **CalendarService** has all methods to search the available timeslots based on the input.


## Steps to test the solution
1. Clone the project on the local system.
2. Open the project on Intellij IDE and add a new Run configuration by selecting the Main class.
3. On click of Run, the program will excecute.

