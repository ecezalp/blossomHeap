CREATE TABLE flowers (
    Id int NOT NULL PRIMARY KEY,
    Color varchar(255) NOT NULL,
    Petal_Count int NOT NULL,
    Petal_Shape varchar(255) NOT NULL,
    Center_Color varchar(255) NOT NULL,
    User_Id int NOT NULL,
    Creation_date TIMESTAMP
)