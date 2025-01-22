<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
        }
        .calculator {
            width: 400px;
            border: 2px solid #ccc;
            border-radius: 10px;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: grid;
            grid-template-columns: repeat(3, 1fr) 1fr; /* 3 columns for numbers and 1 for operators */
            grid-template-rows: repeat(4, 70px); /* 4 rows for buttons */
        }
        #display {
            grid-column: span 4; /* Display spans all columns */
            width: 100%;
            height: 50px;
            text-align: right;
            font-size: 24px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding-right: 10px;
        }
        .button {
            width: 100%;
            height: 100%;
            margin: 5px; /* Margin for spacing */
            font-size: 24px;
            cursor: pointer;
            border-radius: 5px;
            border: none;
            background-color: #007BFF; /* Blue for number buttons */
            color: white;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
        .button.operator {
            background-color: #28a745; /* Green for operators */
        }
        .button.operator:hover {
            background-color: #218838; /* Darker green on hover */
        }
        .button.clear {
            background-color: #dc3545; /* Red for clear */
        }
        .button.clear:hover {
            background-color: #c82333; /* Darker red on hover */
        }
    </style>
</head>
<body>
    <div class="calculator">
        <input type="text" id="display" disabled />
        
        <!-- Number Buttons -->
        <input type="button" class="button" value="7" onclick="addToDisplay('7')" />
        <input type="button" class="button" value="8" onclick="addToDisplay('8')" />
        <input type="button" class="button" value="9" onclick="addToDisplay('9')" />

        <input type="button" class="button" value="4" onclick="addToDisplay('4')" />
        <input type="button" class="button" value="5" onclick="addToDisplay('5')" />
        <input type="button" class="button" value="6" onclick="addToDisplay('6')" />

        <input type="button" class="button" value="1" onclick="addToDisplay('1')" />
        <input type="button" class="button" value="2" onclick="addToDisplay('2')" />
        <input type="button" class="button" value="3" onclick="addToDisplay('3')" />

        <input type="button" class="button clear" value="C" onclick="clearDisplay()" />
        <input type="button" class="button" value="0" onclick="addToDisplay('0')" />

        <!-- Operator Buttons -->
        <input type="button" class="button operator" value="/" onclick="addToDisplay('/')" />
        <input type="button" class="button operator" value="" onclick ="backspace()" style = "height : calc(100% -10px);"/> <!-- Backspace -->
        <input type="button" class="button operator calculate-button" value=" =" onclick ="calculate()" style = "height : calc(100% -10px);"/> <!-- Enter -->
        
        <input type = "submit"class = "operator button operator "value = "+"onclick ="addToDisplay('+')"/>
         <input type = "submit"class = "operator button operator "value = "-"onclick ="addToDisplay('-')"/>
         <input type = "submit"class = "operator button operator "value = "*"onclick ="addToDisplay('*')"/>
    </div>

    <script>
        function addToDisplay(value) {
            document.getElementById("display").value += value;
        }

        function clearDisplay() {
            document.getElementById("display").value = '';
        }

         function backspace() {
             let currentValue = document.getElementById("display").value;
             document.getElementById("display").value = currentValue.slice(0, -1);
         }

         function calculate() {
             try {
                 let result = eval(document.getElementById("display").value);
                 document.getElementById("display").value = result;
             } catch (e) {
                 document.getElementById("display").value = 'Error';
             }
         }
    </script>
</body>
</html>
