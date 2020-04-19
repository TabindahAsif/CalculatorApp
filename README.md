# Calculator App
This was my first android project, purpose of this project to do a getting started in android development.

### Learning
From this project I learned...
1. Making a complex layout.
2. Binding layout's view elements in java's code using [findViewById](https://developer.android.com/reference/android/view/View#findViewById(int)) to proper variable and then using them.
3. Adding a single [onClickListener](https://developer.android.com/reference/android/view/View.OnClickListener) to multiple view and handling them accordingly.
4. Breaking and evaluating the basic mathematical expression using java's [String.split](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String)) and [regex](https://docs.oracle.com/javase/tutorial/essential/regex/)

## Using
You can use this project by cloning or checking out.

### Check out in Android Studio.
Follow these furhter steps to checkout and use in android studio.

1. Open Android Studio and select ** Check out project from version ** then ** Git **
 ![Checkout](https://github.com/TabindahAsif/CalculatorApp/blob/master/checkout.png)

2. Now enter this URL [https://github.com/TabindahAsif/CalculatorApp.git](https://github.com/TabindahAsif/CalculatorApp.git) ** and select the directory where you want to save it then click on clone.** 
 ![URL](https://github.com/TabindahAsif/CalculatorApp/blob/master/clone.png)

3. After successfull Checkout you can open this project by click ** Yes ** on this prompt.
 ![Open](https://github.com/TabindahAsif/CalculatorApp/blob/master/open.png)

4. After Editing or adding new Feature, You can update this Repository by Selecting Commiting and Pushing.
 ![Push](https://github.com/TabindahAsif/CalculatorApp/blob/master/push.png)

## Technical Summary

### These are the Technical details of above point given in Learning.

1. Created a **BtnController** class which will implement OnClickListener, by doing so we can provide single listener to multiple views.
```java
class BtnController implements OnClickListener { }
```

2. Next in the onClick method of above class, we added a switch statement that will handle each view's logic.
```java
public void onClick(View v) {
    try {
        String toAppend=ScreenResult.getText().toString();
        switch (v.getId()) {
            case R.id.Addbtn:
                toAppend += "+";
                break;
            case R.id.Dividebtn:
                toAppend += "/";
                break;
            case R.id.Dot:
                toAppend += ".";
                break;
                //So on.....
        }
        ScreenResult.setText(toAppend);
    } catch (Exception e) {

}
```

3. In the onCreate of Activity class we maded an instance of above btnController and set it on every relevent view.
```java
BtnController btnC = new BtnController();
this.one = (Button) findViewById(R.id.One);
this.one.setOnClickListener(btnC);
```

4. Now Mathematical Expression, After user enter a simple expression like **1 + 1** we break it using split.
```java
expression += ScreenResult.getText();
String[] values = expression.split("[\\+\\-\\*\\/]");
```
above code get user expression, and regex expression told it to break string if found one of any **+ - * /** , suppose expression is **1 + 1** so the split will give us array like **["1" , "1"]**

5. Now we have each value in **value** array, so now we proceed to evaluating.
```java
Double val1 = Double.parseDouble(values[0]);
Double val2 = Double.parseDouble(values[1]);
if (expression.indexOf('+') != -1) {
    res = val1 + val2;
} else if (expression.indexOf('-') != -1) {
    res = val1 - val2;
} else if (expression.indexOf('*') != -1) {
    res = val1 * val2;
} else if (expression.indexOf('/') != -1) {
    res = val1 / val2;
}
```
As we support simple expression like **1 + 1**, So in above code we seacrh for operator in origional expression string, then proceed it on previously splitted values.

## Thats All :-) , you can find out further details by reviwinf the code.

## This is Main Screen
 ![Preview](https://github.com/TabindahAsif/CalculatorApp/blob/master/preview.png)
