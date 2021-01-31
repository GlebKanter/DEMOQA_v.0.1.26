package com.telran.applications;

import com.telran.models.ModelBase;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> valid(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"John","Doe","fggf@fg.djfg","Male","356258656","12 Avgust 2005","Maths","Music","Herzel 15/2","NCR","Noida"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validFromFile() throws IOException {
        List<Object[]> list= new ArrayList<>();

        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line=reader.readLine();
        while (line!=null){
            String[] split=line.split(";");
            list.add(new Object[]{new ModelBase()
                    .withFild1(split[0])
                    .withFild2(split[1])
                    .withFild3(split[2])
                    .withFild4(split[3])
                    .withFild5(split[4])
                    .withFild6(split[5])
                    .withFild7(split[6])
                    .withFild8(split[7])
                    .withFild9(split[8])
                    .withFild10(split[9])
                    .withFild11(split[10])
            });
            line=reader.readLine();
        }

        return list.iterator();
    }


}
