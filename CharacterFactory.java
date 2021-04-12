/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.ait.k17104;

import java.util.Random;

/**
 *
 * @author k17104kk
 */
public class CharacterFactory {
    // 敵の名前の配列より、ランダムの1つが選ばれて生成されます
    private static final String[] ENEMY_NAMES = {"イノシシ", "鹿", "野良犬", "たぬき", "くま"};

    // 勇者を召喚して返す
    public static Hero createHero(String name) {

        Random random = new Random();

        // パラメータをランダムに設定
        int hp = random.nextInt(41) + 80;  // 80〜120
        int atk = random.nextInt(8) + 8;  // 8〜15
        int def = random.nextInt(8) + 8;  // 8〜15
        int agi = random.nextInt(8) + 8;  // 8〜15

        // 勇者を生成して返す
        return new Hero(name, hp, atk, def, agi);

    }

    // 敵を生み出して返す
    public static Enemy createEnemy() {

        Random random = new Random();

        // 上で設定した敵の名前の配列からランダムな要素を取り出し
        String name = ENEMY_NAMES[random.nextInt(ENEMY_NAMES.length)];

        // パラメータをランダムに設定
        int hp = random.nextInt(151) + 50;  // 50〜200 変化量150 に50のバイアス
        int atk = random.nextInt(11) + 5;  // 5〜15
        int def = random.nextInt(6) + 5;  // 5〜10
        int agi = random.nextInt(11) + 10;  // 10〜20

        // 敵を生成して返す
        return new Enemy(name, hp, atk, def, agi);


}
}
