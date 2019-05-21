-- Exercise 2
-- Select the warehouse code and the average value of the boxes in each warehouse.
Select warehouse, avg(value) from boxes group by warehouse;

-- Exercise 3
-- Select the warehouse code and the average value of the boxes in each warehouse, but select only those warehouses where the average value of the boxes is greater than 150.
--
Select warehouse, avg(value) from boxes group by warehouse having avg(value)>150;

-- Exercise 4
-- Find all values per each content in the Boxes table.
--
Select contents, sum(value) from boxes group by contents;

-- Exercise 5
-- Find the total value of all boxes.
--
Select sum(value) from boxes;

-- Exercise 6
-- Reduce the value of all boxes by 15%.
--
UPDATE boxes SET value= value*0.85;

-- Exercise 7
-- Remove all boxes with a value lower than $100.
DELETE FROM boxes WHERE value<100;