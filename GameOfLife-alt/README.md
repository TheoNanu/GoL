# GameOfLife
GameOfLife - simulation of a cell population

### Team members

Bogdana Nan

Robert Fitoiu

Bogdan Cosma

Theodor Nanu

### Installation

Our project does not have any type of special installation, you just need to download the zip file, import it in a Java IDE and run the Main Class.

### Project Description

Game of Life is a simulation of a cell population which has as a scope to reproduce and to eat. There is a limited number of food units for the population. One food unit is enough to feed one cell for a period of time ``timeFull`` and after that the cell gets hungry again. If it does not eat for a period of time equal with ``timeStarve`` the cell dies and it produces a random amount of food units between 1 and 5.

If a cell eats 10 times it can reproduce itself in a different manner depending on its type. There are two types of cells: ``CelulaAsexuata`` cells which can reproduce themselves without the help of another cell and the result is two hungry cells.

The other type of cell is the ``CelulaSexuata`` cell which needs another cell to be ready to reproduce, namely they need another cell to have been eating 10 times. This will result in one additional cell which will be hungry at first.

Every cell is represented in our program by a different thread.

At start we have 1 ``CelulaAsexuata`` cell type and 2 ``CelulaSexuata`` cells type.

The ``CelulaSexuata`` cells type can divide themselves only if they ate 10 times and they are adjacent cells int the ``cells`` ArrayList which is part of the class ``CelulaSexuataArrayWrapper``.

The ``Food`` class acts like a monitor, all of the methods which are related to the integrity of the variable ``foodUnits`` are made synchronized in order to preserve the integrity of the value stored in memory and avoid the race conditions that might appear. The class ``CelulaSexuataArrayWrapper`` acts in a similar manner but this time the values that are protected are the ones from the ``cells`` ArrayList.

The ``foodUnits``, ``timeFull`` and ``timeStarve`` values can be configured from the file ``config.properties``.