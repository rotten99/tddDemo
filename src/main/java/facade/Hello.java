package facade;


import java.util.ArrayList;

public class Hello {
    public String sayHello(Object o) {
        String name = "";
        String exclamation = ".";

        if (o instanceof String) {
            name = (String) o;
        }
        else if (o instanceof String[]) {
            String[] arr = (String[]) o;
            ArrayList<String> arrList = new ArrayList();

            for (int i = 0; i < arr.length; i++) {

                if(arr[i].contains(",") && !arr[i].contains("\"")){
                    String[] arr2 = arr[i].split(",");
                    arrList.add(arr2[0]);
                    arrList.add(arr2[1]);
                }
                else if(arr[i].contains("\"")){
                    arr[i]=arr[i].replace("\"","");
                    arrList.add(arr[i]);
                }
                else{
                    arrList.add(arr[i]);
                }
            }
            String[] newArr = new String[arrList.size()];
            for(int i=0; i< newArr.length;i++){
                newArr[i]=arrList.get(i);
            }
            arr = newArr;

            String end = "AND HELLO ";
            String wait = "";

            for (int i = 0; i < arr.length; i++) {
                if (!isAllUpper(arr[i])) {
                    if (name.equals("")) {
                        name = arr[i];
                    } else {
                        if (!wait.equals("")){
                            name += ", " + wait;
                        }
                        wait = arr[i];
                    }
                } else {
                    exclamation = "!";
                    if (end.equals("AND HELLO ")) {
                        end += arr[i];
                    } else {
                        end += ", " + arr[i];
                    }
                }
            }

            if (!name.equals("") && !wait.equals("") && name.contains(",")) {
                name += ", and " + wait;
            }
            else{
                name += " and " + wait;
            }

            if (!end.equals("AND HELLO ")) {
                name += ". " + end;
            }
        }

        if (o == null) {
            name = "my friend";
        } else if (isAllUpper(name)) {
            exclamation = "!";
        }


        return "Hello, " + name + exclamation;
    }

    private boolean isAllUpper(String name) {
        if (name.chars().allMatch(Character::isUpperCase) == true) {
            return true;
        }
        return false;
    }
}
