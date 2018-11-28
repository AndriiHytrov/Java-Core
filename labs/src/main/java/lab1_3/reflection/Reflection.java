package lab1_3.reflection;

import lab1_3.analyzer.Analyzer;
import lab1_3.fillers.AnotationFiller;
import lab1_3.fillers.Fillers;
import lab1_3.sorters.Sorters;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Reflection {

    Sorters sorters;
    Analyzer analyzer = new Analyzer();
    List<int[]> arrayList = new ArrayList<>();
    List<Class> classSortList = new ArrayList<>();


    public void Analyze() throws IllegalAccessException, InstantiationException, ClassNotFoundException,
            NoSuchMethodException {
        for(int[] i: arrayList){
            for(Class cl: classSortList){
                sorters = (Sorters) cl.newInstance();
                analyzer.SortTimeAnalyzer(i, sorters);
            }
        }
    }



    private void getAnnotationMethods(){

        int length;
        length = 10;
        Fillers fillers = new Fillers();
        Class aClass = fillers.getClass();

        Method[] methods = aClass.getDeclaredMethods();
        List<Method> methodList = new ArrayList<Method>(); //list with annotation method

        for(Method method:methods) {
                try {
                    if(method.isAnnotationPresent(AnotationFiller.class)) {
                        arrayList.add(((int[]) method.invoke(fillers, length)));
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    //don't forget
                }
        }

//        for(int[] i:arrayList) {
//            for(int j:i){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
    }

    public void getHeirClass() {

        Reflections reflections = new Reflections("com.course.lab1_3.sorters");
        Set<Class<?extends Sorters>> childClass = reflections.getSubTypesOf(Sorters.class);
        for(Class c: childClass) {
            if (findParent(c) == null) {                   //costyl'
                continue;
            }
            classSortList.add(findParent(c));
        }
    }

    private Class findParent( Class c) {
        Class clazz = c.getSuperclass();
        while (!clazz.equals(Sorters.class)) {
            clazz = clazz.getSuperclass();
        }
        if (clazz.equals(Sorters.class)) {
            if (Modifier.isAbstract(c.getModifiers())) {
                return null;
            }
        } else {
            findParent(clazz);
        }
        return c;
    }

    public void f(){
        for (Class cl: classSortList){
            System.out.println(cl);
        }
    }
}
