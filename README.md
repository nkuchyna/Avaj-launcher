# Avaj-launcher
Implementation a minimal aircraft simulation program based on a given UML class diagram | UNIT factory
------------------------------------------------------------------------------------------------------
The main goal was to implement an aircraft simulation program based on the class diagram provided. All classes were required to be implemented respecting every detail provided in the diagram.

**To run program:** run compile.sh script, where indicated scenario file.

*Scenario file description:*
The first line of the file contains a positive integer number. This number represents the number of times the simulation is run. In our case, this will be the number of times a weather change is triggered. Each following line describes an aircraft that will be part of the simulation, with this format: TYPE NAME LONGITUDE LATITUDE HEIGHT.

Executing the program generates a file ***simulation.txt*** that describes the outcome of the simulation.

![avaj_uml_diagram](https://github.com/nkuchyna/Avaj-launcher/blob/master/src/avaj_uml.jpg)
