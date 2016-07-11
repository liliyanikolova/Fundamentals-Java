package homeworks._09_PizzaTime;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class  Pizza{

    public Map<Integer, List<String>> getGroupsWithPizza(String... input){
        Map<Integer, List<String>> pizzaByGroup = new HashMap<>();
        Pattern pattern = Pattern.compile("([0-9]+)(\\w+)");
        for (String pizza : input) {
            Matcher matcher = pattern.matcher(pizza);
            if (matcher.find()){
                Integer group = Integer.parseInt(matcher.group(1));
                String pizzaName = matcher.group(2);
                if (!pizzaByGroup.containsKey(group)){
                    pizzaByGroup.put(group, new LinkedList<>());
                }

                pizzaByGroup.get(group).add(pizzaName);
            }
        }

        return pizzaByGroup;
    }
}

public class Pr09PizzaTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        Pizza pizza = new Pizza();
        Map<Integer, List<String>> pizzaByGroups = pizza.getGroupsWithPizza(input);
        for (Map.Entry<Integer,List<String>> pizzaEntry : pizzaByGroups.entrySet()) {
            System.out.println(pizzaEntry.getKey() + " - " + String.join(", ", pizzaEntry.getValue()));
        }

        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }

    }
}
