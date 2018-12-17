package helper;

import java.util.regex.Pattern;

public class ValidationHelper {
	/**
	 * 最小文字列判定.
	 * 文字列がn文字以下ではないかを調べます.判定が違う時はStringのエラー文を出します.判定が正しければ戻り値はNullです.
	 * @param number 最小文字数
	 * @param string 対象文字列
	 * @param content 対象文字列の名前
	 * @return "content" は、"number"文字以上でなければなりません。
	 * @author mizuki_ono,kawaguti
	 */
   public static String minimumText(int number, String string, String content) {
         String result = null;
        if (string.length() <= number) {
            result = content + "は、" + Integer.toString(number) + "文字以上でなければなりません。";
        }
        return result;
    }
	/**
	 * 最大文字列判定.
	 * 文字列がn文字以上ではないかを調べます.判定が違う時はStringのエラー文を出します.判定が正しければ戻り値はNullです.
	 * @param number 最大文字数
	 * @param string 対象文字列
	 * @param content 対象文字列の名前
	 * @return "content" は、"number"文字以内でなければなりません。
	 * @author mizuki_ono,kawaguti
	 */
	public static String maximumText(int number, String string, String content) {
		String result = null;
		if (string.length() >= number) {
			result = content + "は、" + Integer.toString(number) + "文字以内でなければなりません。";
		}
		return result;
	}
    /**
     * 文字列正規表現判定.文字列が正規表現に合っているかを判定します.<br>判定が違う時はStringのエラー文を出します.判定が正しければ戻り値はNullです.<br>
     * 正規表現を調べたいときは<a href="http://www.turtle.gr.jp/techno/regular-expression.html">この正規表現のサイト</a>が一番わかりやすいと思います.<br>
     * 厳密なのはMicrosoftのページですが上記のやつでも十分でした.
     * <a href="https://msdn.microsoft.com/ja-jp/library/cc392020.aspx">マイクロソフト正規表現の構文</a>
     * @param regularExpression 正規表現
     * @param string 対象文字列
     * @param content 対象文字列の名前
     * @return content + "は、" + regularExpression + "の形式でなければなりません。"
     * @author mizuki_ono,kawaguti
     */
    public static String regularExpressionText(String regularExpression, String string, String content) {
        String result = null;
        Pattern pattern = Pattern.compile(regularExpression);
        if (!(pattern.matcher(string).find())) {
            result = content + "は、" + regularExpression + "の形式でなければなりません。";
        }
        return result;
    }
    /**<h1>注意:未実装</h1>
     *  単一ユニーク判定<br>文字列がDBの中でユニークであるか調べます.<br>
     * @param columnName カラム名
     * @param tableName テーブル名
     * @param string
     * @param content
     * @return
     */
    public static String uniqueText(String columnName, String tableName, String string, String content) {
    	//価値観とメールで使うから実装はよ
        String result = null;
        /*      System.out.println(tableDAO.selectStudentByEmail(string));
                result = content + "は、" + "すでに使われています。";
        }
        */
        return result;
    }
}
