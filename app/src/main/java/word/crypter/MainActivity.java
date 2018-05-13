package word.crypter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final int KEYCODE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void cryptIt(View view) {
        EditText wordToCrypt = findViewById(R.id.getWordToCrypt);
        TextView cryptedWord = findViewById(R.id.cryptedWord);

        String text = wordToCrypt.getText().toString();

        StringBuilder wordCrypt = new StringBuilder();
        ArrayList<String> cryptArray = cryptText(text);
        for(int index = 0; index < cryptArray.size(); index++) {
            wordCrypt.append(cryptArray.get(index));
        }

        cryptedWord.setText(wordCrypt);
    }

    protected void decryptIt(View view) {
        EditText decryptKey = findViewById(R.id.decryptEditText);
        EditText wordToCrypt = findViewById(R.id.getWordToCrypt);
        TextView decryptedText = findViewById(R.id.decryptedWord);

        String text = wordToCrypt.getText().toString();
        StringBuilder wordCrypt = new StringBuilder();

        int decryptKeyCode = Integer.parseInt(decryptKey.getText().toString());

        ArrayList<String> cryptArray = decryptText(text, decryptKeyCode);
        for(int index = 0; index < cryptArray.size(); index++) {
            wordCrypt.append(cryptArray.get(index));
        }

        if(decryptKeyCode == KEYCODE) {
            decryptedText.setText(wordCrypt);
        } else {
            decryptedText.setText("Wrong Keycode!");
        }

    }
    private ArrayList<String> cryptText(String text) {
        int a = 40, b = 51, c = 3, d = 19, e = 16, f = 47, g = 4, h = 5, i = 53, j = 38, k = 14, l = 9, m = 50, n = 34, o = 1, p = 44, q = 13, r = 28, s = 22, t = 43, u = 32, v = 8, w = 12, x = 27, y = 37, z = 2, ä = 25, ö = 17;
        int A = 6, B = 18, C = 11, D = 36, E = 39, F = 0, G = 15, H = 46, I = 31, J = 35, K = 54, L = 20, M = 41, N = 52, O = 48, P = 29, Q = 21, R = 49, S = 30, T = 4, U = 45, V = 33, W = 26, X = 24, Y = 23, Z = 42, Ä = 10, Ö = 7;

        Map values = new HashMap();
        values.put("a", a);
        values.put("b", b);
        values.put("c", c);
        values.put("d", d);
        values.put("e", e);
        values.put("f", f);
        values.put("g", g);
        values.put("h", h);
        values.put("i", i);
        values.put("j", j);
        values.put("k", k);
        values.put("l", l);
        values.put("m", m);
        values.put("n", n);
        values.put("o", o);
        values.put("p", p);
        values.put("q", q);
        values.put("r", r);
        values.put("s", s);
        values.put("t", t);
        values.put("u", u);
        values.put("v", v);
        values.put("w", w);
        values.put("x", x);
        values.put("y", y);
        values.put("z", z);
        values.put("ä", ä);
        values.put("ö", ö);
        values.put("A", A);
        values.put("B", B);
        values.put("C", C);
        values.put("D", D);
        values.put("E", E);
        values.put("F", F);
        values.put("G", G);
        values.put("H", H);
        values.put("I", I);
        values.put("J", J);
        values.put("K", K);
        values.put("L", L);
        values.put("M", M);
        values.put("N", N);
        values.put("O", O);
        values.put("P", P);
        values.put("Q", Q);
        values.put("R", R);
        values.put("S", S);
        values.put("T", T);
        values.put("U", U);
        values.put("V", V);
        values.put("W", W);
        values.put("X", X);
        values.put("Y", Y);
        values.put("Z", Z);
        values.put("Ä", Ä);
        values.put("Ö", Ö);

        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<String> secondStringArrayList = new ArrayList<>();
//Loop through every character given in the editText.
        for (char ch : text.toCharArray()) {
            //Iterate through the value map.
            for (Object key : values.keySet()) {
                //Set the current character to String.
                String test = "" + ch;
                if (values.containsKey(test)) {
                    //When value is found from the map, multiple it by 4.
                    int secretMultiple = ((int) values.get(test)) * KEYCODE;
                    //Add the multiplied value to a String array so it can be converted to charArray.
                    stringArrayList.add(secretMultiple + "");
                    break;
                }
            }
        }

        //Go through every item in the StringArrayList.
        for(int index = 0; index < stringArrayList.size(); index++) {
            //Chop the current item into single characters and convert them into letters.
            StringBuilder tempWordBuilder = new StringBuilder();
            for(int index2 = 0; index2 < stringArrayList.get(index).toCharArray().length; index2++) {
                int tempVal = (stringArrayList.get(index).charAt(index2)) - '0';
                if(values.containsValue(tempVal)){
                    tempWordBuilder.append(getKeyFromValue(values,tempVal).toString()); }
            }
            secondStringArrayList.add(tempWordBuilder.toString());
        }

        return secondStringArrayList;
    }
    private ArrayList<String> decryptText(String text, int keyCode) {
        int a = 40, b = 51, c = 3, d = 19, e = 16, f = 47, g = 4, h = 5, i = 53, j = 38, k = 14, l = 9, m = 50, n = 34, o = 1, p = 44, q = 13, r = 28, s = 22, t = 43, u = 32, v = 8, w = 12, x = 27, y = 37, z = 2, ä = 25, ö = 17;
        int A = 6, B = 18, C = 11, D = 36, E = 39, F = 0, G = 15, H = 46, I = 31, J = 35, K = 54, L = 20, M = 41, N = 52, O = 48, P = 29, Q = 21, R = 49, S = 30, T = 4, U = 45, V = 33, W = 26, X = 24, Y = 23, Z = 42, Ä = 10, Ö = 7;

        Map values = new HashMap();
        values.put("a", a);
        values.put("b", b);
        values.put("c", c);
        values.put("d", d);
        values.put("e", e);
        values.put("f", f);
        values.put("g", g);
        values.put("h", h);
        values.put("i", i);
        values.put("j", j);
        values.put("k", k);
        values.put("l", l);
        values.put("m", m);
        values.put("n", n);
        values.put("o", o);
        values.put("p", p);
        values.put("q", q);
        values.put("r", r);
        values.put("s", s);
        values.put("t", t);
        values.put("u", u);
        values.put("v", v);
        values.put("w", w);
        values.put("x", x);
        values.put("y", y);
        values.put("z", z);
        values.put("ä", ä);
        values.put("ö", ö);
        values.put("A", A);
        values.put("B", B);
        values.put("C", C);
        values.put("D", D);
        values.put("E", E);
        values.put("F", F);
        values.put("G", G);
        values.put("H", H);
        values.put("I", I);
        values.put("J", J);
        values.put("K", K);
        values.put("L", L);
        values.put("M", M);
        values.put("N", N);
        values.put("O", O);
        values.put("P", P);
        values.put("Q", Q);
        values.put("R", R);
        values.put("S", S);
        values.put("T", T);
        values.put("U", U);
        values.put("V", V);
        values.put("W", W);
        values.put("X", X);
        values.put("Y", Y);
        values.put("Z", Z);
        values.put("Ä", Ä);
        values.put("Ö", Ö);

        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<String> secondStringArrayList = new ArrayList<>();
        ArrayList<String> thirdStringArrayList = new ArrayList<>();
        ArrayList<String> cryptArray = cryptText(text);
        for(int index = 0; index < cryptArray.size(); index++) {
            StringBuilder tempWordBuilder = new StringBuilder();
            for(int index2 = 0; index2 < cryptArray.get(index).toCharArray().length; index2++) {
                String tempVal = cryptArray.get(index).charAt(index2) + "";
                if(values.containsKey(tempVal)){
                    tempWordBuilder.append(values.get(tempVal));
                }
            }
            stringArrayList.add(tempWordBuilder.toString());
        }

        for(int index = 0; index < stringArrayList.size(); index++) {
            int tempInt = Integer.parseInt(stringArrayList.get(index));
            tempInt = tempInt / keyCode;
            secondStringArrayList.add(tempInt + "");
        }

        for(int index = 0; index < secondStringArrayList.size(); index++) {
            StringBuilder tempWordBuilder = new StringBuilder();
            int tempVal = Integer.parseInt(secondStringArrayList.get(index));
            if(values.containsValue(tempVal)){
                tempWordBuilder.append(getKeyFromValue(values, tempVal));
            }
            thirdStringArrayList.add(tempWordBuilder.toString());
        }

        return thirdStringArrayList;
    }
    private static Object getKeyFromValue(Map hm, Object value) {
        for (Object ob : hm.keySet()) {
            if (hm.get(ob).equals(value)) {
                return ob;
            }
        }
        return null;
    }
}