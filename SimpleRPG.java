/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.ait.k17104;

import java.util.Scanner;
/**
 *
 * @author k17104kk
 */
public class SimpleRPG {
    
    public static void main(String[] args) {
    // 画面からの入力待受用
        Scanner sc = new Scanner(System.in);

        // 画面から勇者の名前を入力
        System.out.println("よくぞ参った勇者よ！お主の名前を言うが良い！！１");
        System.out.println("システム: あなたの名前を入力してください。");
        String hero_name = sc.nextLine();   // 勇者の名前を入力

        System.out.println("では、" + hero_name + "よ！お主のこの世界での力量を占いによって決定しよう。しばし待つのじゃ。");

        // 勇者を生成
        Hero h = CharacterFactory.createHero(hero_name);

        // 勇者のステータスを表示しましょう
        System.out.println("---------------------------------------------");
        printStatus(h);
        System.out.println("---------------------------------------------");


        System.out.println("いつまでそこに居るのじゃ、さっさと行かんか！！１");

        System.out.println("システム: 勇者" + h.getName() + "は旅に出ました。");

        System.out.println("システム: 街の門を出たところ、目の前に影が現れました。");


        // 敵生成
        Enemy e = CharacterFactory.createEnemy();

        // ステータスを表示しましょう
        System.out.println("---------------------------------------------");
        printStatus(e);
        System.out.println("---------------------------------------------");

        System.out.println("システム: さぁ眼の前の障害は取っ払いましょう。");

        // 勇者の素早さと敵の素早さを比較
        if (h.getAgi() >= e.getAgi()) {

            // 勇者が早い:

            // 無限ループの開始
            while (true) {
                // 勇者の行動開始
                // 勇者の行動決定メッセージ
                System.out.println("システム: 勇者の行動を選択してください。(1: 攻撃, それ以外: 逃亡)");
                String hero_action = sc.nextLine();

                // "1"が選択されたか
                if (hero_action.equals("1")) {
                    // 敵に攻撃
                    int damage_to_e = h.attack(e);
                    System.out.println("勇者の攻撃: " + e.getName() + "に" + damage_to_e + "のダメージ！");

                    printStatus(h, e);

                    // 敵のHPが 0か
                    if (e.getHp() <= 0) {
                        // ゲームクリアによりプログラムを終了
                        System.out.println("システム: 眼の前の障害は無残にも飛び散りました。");
                        System.out.println("システム: ゲームクリアです。あなたの冒険はまだまだ続きますが一旦ここまで。");
                        return;
                    }
                } else {
                // それ以外
                    // 逃亡によりプログラムを終了
                    System.out.println("システム: あなたは尻尾を巻いて逃げ出しました。");
                    System.out.println("システム: あなたの冒険はここで終わりです。この意気地なし。");
                    return;
                }
                // 勇者の行動終わり

                // 敵の行動開始
                int damage_to_h = e.attack(h);
                System.out.println(e.getName() + "の攻撃: 勇者は" + damage_to_h + "のダメージを受けた！");

                printStatus(h, e);

                // 勇者のHPが 0 か
                if (h.getHp() <= 0) {
                    // ゲームオーバーによりプログラム終了
                    System.out.println("システム: あなたは" + e.getName() + "の苛烈な攻撃により命を落としました……。");
                    System.out.println("ゲームオーバー");
                    return;
                }
                // 敵の行動終わり
            // 無限ループの終端
            }
        //
        } else {


            // 敵が早い:


            // 無限ループの開始
            while (true) {

                // 敵の行動開始
                int damage_to_h = e.attack(h);
                System.out.println(e.getName() + "の攻撃: 勇者は" + damage_to_h + "のダメージを受けた！");

                printStatus(h, e);

                // 勇者のHPが 0 か
                if (h.getHp() <= 0) {
                    // ゲームオーバーによりプログラム終了
                    System.out.println("システム: あなたは" + e.getName() + "の苛烈な攻撃により命を落としました……。");
                    System.out.println("ゲームオーバー");
                    return;
                }
                // 敵の行動終わり

                // 勇者の行動開始
                // 勇者の行動決定メッセージ
                System.out.println("システム: 勇者の行動を選択してください。(1: 攻撃, それ以外: 逃亡)");
                String hero_action = sc.nextLine();

                // "1"が選択されたか
                if (hero_action.equals("1")) {
                    // 敵に攻撃
                    int damage_to_e = h.attack(e);
                    System.out.println("勇者の攻撃: " + e.getName() + "に" + damage_to_e + "のダメージ！");

                    printStatus(h, e);

                    // 敵のHPが 0か
                    if (e.getHp() <= 0) {
                        // ゲームクリアによりプログラムを終了
                        System.out.println("システム: 眼の前の障害は無残にも飛び散りました。");
                        System.out.println("システム: ゲームクリアです。あなたの冒険はまだまだ続きますが一旦ここまで。");
                        return;
                    }
                } else {
                    // それ以外
                    // 逃亡によりプログラムを終了
                    System.out.println("システム: あなたは尻尾を巻いて逃げ出しました。");
                    System.out.println("システム: あなたの冒険はここで終わりです。この意気地なし。");
                    return;
                }
                // 勇者の行動終わり

                // 無限ループの終端
            }
        }
        // 終了
    }

    private static void printStatus(Hero h) {
        System.out.println("勇者: " + h.getName() + " HP:" + h.getHp() + " ATK:" + h.getAtk() + " DEF:" + h.getDef() + " AGI:" + h.getAgi());
    }

    private static void printStatus(Enemy e) {
        System.out.println("敵　: " + e.getName() + " HP:" + e.getHp() + " ATK:" + e.getAtk() + " DEF:" + e.getDef() + " AGI:" + e.getAgi());
    }
    private static void printStatus(Hero h, Enemy e) {
        System.out.println("---------------------------------------------");
        printStatus(h);
        printStatus(e);
        System.out.println("---------------------------------------------");
    }

    
}
