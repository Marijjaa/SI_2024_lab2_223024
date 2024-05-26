# SI_2024_lab2_223024
#### Control Flow Graph (броевите искоментирани во кодот)
![](https://github.com/Marijjaa/SI_2024_lab2_223024/blob/master/CFG.png)
#### Цикломатска комплексност 
Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на if-ови во кодот. Во случајoв P=9, па цикломатската комплексност изнесува 2.
#### Every-branch критериум
Мора да има 5 тестови за да се поминат сите ребра на графот. 3-тестови кои ќе и изминат исклучоците и ќе влезат во најголем дел од if-овите, и уште 2-теста без исклучоци за да поминат низ последните два
if-a(еден со доволна уплата и еден со помала уплата од што е потребна) <br>
Тест 1: <br>
0 продукти, 500 денари уплата <br>
("allItems list can't be null!") <br>
Тест 2: <br>
Item[] list1 = new Item[]{ new Item(null,"0123",500,0.7f), new Item("i1","1234",50,0), new Item("i2",null,70,0) }; <br>
("No barcode!") <br>
Тест 3: <br>
Item[] list2 = new Item[]{ new Item("i1","@245", 100, 0)}; <br>
("Invalid character in item barcode!") <br>
Тест 4: <br>
Item[] list3 = new Item[]{ new Item("i1","0123", 500, 0.7f)}; <br>
Уплата: 600 денари(доволно) <br>
Тест 5: <br>
Item[] list4 = new Item[]{ new Item("i1","0123", 500, 0.7f)}; <br>
Уплата: 200 денари(недоволно) <br>
####  Multiple Condition критериум
Мора да има 4 тестови за if condition-от(TTT, TTF, TFX, FXX) <br>
//TTT <br>
Item[] list1 = new Item[]{ new Item("i1","0123", 500, 0.7f)}; <br>
//TTF <br> 
Item[] list2 = new Item[]{ new Item("i2", "1234", 500, 0.7f)}; <br>
//TFX <br>
Item[] list3 = new Item[]{ new Item("i3", "0123", 500, 0.0f)}; <br>
//FXX <br>
Item[] list4 = new Item[]{ new Item("i4", "0123", 100, 0.7f)};
