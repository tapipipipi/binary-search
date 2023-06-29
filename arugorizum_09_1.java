package Free;

import java.util.Scanner;

public class arugorizum_09_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //上限を設定する
        System.out.print("要素番号の上限を入力してください＞");
        int H = in.nextInt();   //上限
        int Max = H;    //上限値
        int L = 1;  //下限値
        int[] X = new int[H];   //要素
        int K;    //探索値
        int M = 0;  //中央値
        int count = 0;  //条件に合った数字かを判定する変数
        int renge = 0;  //要素数が昇順になるための変数
        int search; //確認時に要素番号を入力する変数

        //配列Xの要素数を設定する
        System.out.print("X |");
        for (int i = 0; i < H; i++){
            int random = (int)(Math.random()*(H+renge) + 1);   //要素数を決める
            //ランダムで出た要素数が昇順かつ被っていないか判断する
            for (int j = 0; j < H; j++){
                if (X[j] == random || X[j] >= random){
                    count++;
                }
            }
            if (count > 0){ //昇順でないもしくは被っているなら初めから
                i--;
                count = 0;
            } else {    //昇順で且つ被っているなら配列Xに値が入る
                renge = random; //ランダムの範囲を増やすことによって確実に次の配列に要素数が代入される
                X[i] = random;
                System.out.print(X[i] + "|");
            }
        }

        //探索値をきめる（今回探索値は必ず配列Xの中にあるとする）
        K =X[(int)(Math.random()*H)];
        //探索値が配列Xの中にない場合も作りたいときは、こちらを使う
        //K = (int)(Math.random()*renge + 1);
        System.out.println();
        System.out.println("K |" + K + "|");

        //要素数の中から探索値Kを2分探索し、その要素番号を出力する
        while (L <= H) {
            M = (L + H) / 2;
            if (X[M-1] == K) {
                System.out.println("探索値" + K + "の要素番号は" + M + "です");
                break;
            } else if (X[M-1] > K) {
                H = M - 1;
            } else if (X[M-1] < K){
                L = M + 1;
            }
        }
        if (X[M-1] != K) System.out.println("見つかりませんでした");

        //各要素数番号の要素数を確認する
        System.out.print("要素数を確認しますか（1：はい、それ以外：いいえ）＞");
        int select = in.nextInt();

        while (true){
            if (select == 1) {
                System.out.print("1~" + Max + "までの要素番号を選択してください＞");
                search = in.nextInt();
                if (search < 1 || search > Max) {
                    System.out.println("エラーが発生しました");   //範囲外の番号を入力すると再入力となる
                } else {
                    System.out.println(search + "番の要素数は" + X[search - 1] + "です");
                    System.out.println();
                    System.out.print("もう1度確認しますか＞（1：はい、それ以外：いいえ）＞");
                    select = in.nextInt();
                }
            }else{
                System.out.println("終了します");
                break;
            }
        }
        in.close();
    }
}
