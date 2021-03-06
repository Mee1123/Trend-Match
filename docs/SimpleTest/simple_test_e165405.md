# 単体テスト報告書

作成：E16-5405　小野瑞貴<br>

改版履歴

版数|日時|内容
---|---|---
1.0|2019/1/14|初版
1.1|2019/1/14|内容精査、更新
2.0|2019/1/15|エラーの一部を解決

## 初めに
機能名に関しては「機能名(機能仕様書の該当機能番号)」と記述.

## テスト内容

### アクター：利用者(アカウントあり)

#### 機能名:「マッチング(5.1.7)」
- トップページにあるマッチング情報とする


|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|アカウントなしユーザーが使用できない|1/14|Ok|
|2   | 学生アカウントが社会人アカウントを参照している  | 1/15|Ok|
|3   | 社会人アカウントが学生アカウントを参照している  | 1/15|Ok|
|4   | アカウントの並び順が計算通りにできている  | 1/15|Ok|
|5   | 価値観を0つ記入しているユーザーが正常にマッチングできている  | 1/15||価値観が１つ以上でないと記入できないのでテスト不可
|6   | 価値観を1つ記入しているユーザーが正常にマッチングできている  | 1/15|Ok|
|7   | 価値観を2つ記入しているユーザーが正常にマッチングできている  | 1/15|Ok|
|8   | 価値観を3つ記入しているユーザーが正常にマッチングできている  |1/15|Ok|
|9   | 価値観を0つ記入しているユーザーを正常にマッチングさせている | 1/15||価値観が１つ以上でないと記入できないのでテスト不可
|10   | 価値観を1つ記入しているユーザーを正常にマッチングさせている  |1/15|Ok|
|11   | 価値観を2つ記入しているユーザーを正常にマッチングさせている  |1/15|Ok|
|12   | 価値観を3つ記入しているユーザーを正常にマッチングさせている  | 1/15|Ok|
|13   | フリースペースがないユーザーをマッチング常に表示させている.  |  1/15|Ok|
|14   | 同じ値のユーザーが登録されていても通常通りマッチングできる.  | 1/15|Ok|
|15   | 削除されたユーザーがマッチングされない  | 1/15|Ok|

#### 機能名:「マッチング閲覧(5.1.8)」
- マッチング閲覧ページとする.

|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|アカウント未登録者がURLを直打ちすることでエラーを起こさない|1回目1/14|ERROR|
|2   | 学生アカウントが社会人アカウントを参照している  | 1/15|Ok|
|3   | 社会人アカウントが学生アカウントを参照している  | 1/15|Ok|
|4   | アカウントの並び順が計算通りにできている  | 1/15|Ok|
|5   | 価値観を0つ記入しているユーザーが正常にマッチングできている  | 1/15||価値観が１つ以上でないと記入できないのでテスト不可
|6   | 価値観を1つ記入しているユーザーが正常にマッチングできている  | 1/15|Ok|
|7   | 価値観を2つ記入しているユーザーが正常にマッチングできている  | 1/15|Ok|
|8   | 価値観を3つ記入しているユーザーが正常にマッチングできている  |1/15|Ok|
|9   | 価値観を0つ記入しているユーザーを正常にマッチングさせている | 1/15||価値観が１つ以上でないと記入できないのでテスト不可
|10   | 価値観を1つ記入しているユーザーを正常にマッチングさせている  |1/15|Ok|
|11   | 価値観を2つ記入しているユーザーを正常にマッチングさせている  |1/15|Ok|
|12   | 価値観を3つ記入しているユーザーを正常にマッチングさせている  | 1/15|Ok|
|13   | フリースペースがないユーザーをマッチング常に表示させている.  |  1/15|Ok|
|14   | 同じ値のユーザーが登録されていても通常通りマッチングできる.  | 1/15|Ok|
|15   | 削除されたユーザーがマッチングされない  | 1/15|Ok|
|16   | URLを直打ちすることでエラーを起こさない  | 1回目1/14|ERROR|


#### 機能名:「ログイン(5.3.1)」


|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|メールアドレスに41文字以上を許可しない|1/14|OK
|2|メールアドレスに全角/半角スペースを許可しない|1/15|ok|
|3|メールアドレスにひらがな/カタカナ/漢字を許可しない|1/14|ok|
|4|メールアドレスに全角英数字を許可しない|1/14|ok|
|5|メールアドレスに正規表現以外を許可しない|1/14|OK
|6|パスワードがテキスト入力できる|1/14|OK
|7|8文字のパスワードを登録することができる|1/14|OK
|8|20文字のパスワードを登録することができる|1/14|OK
|9|パスワード及び確認用パスワードの未入力を許可しない|1/14|OK
|10|パスワードに7文字以下を許可しない|1/14|OK
|11|パスワードに21文字以上を許可しない|1/14|OK
|12|パスワードに全角/半角スペースを許可しない|1/14|
|13|パスワードにひらがな/カタカナ/漢字を許可しない|1/14|OK
|14|パスワードに全角英数字を許可しない|1/14|OK


#### 機能名:「アカウント情報の閲覧(5.3.3)」


|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|機能が実行できる|1/14|OK
|2|所属が無くても表示できる   |  1/15 | ok  |
|3|職種が無くても表示できる   |    1/15 | ok  |
|4|性別が無くても表示できる   |    1/15 | ok  |
|5|連絡先が無くても表示できる   |   1/15 | ok  |
|6|フリースペースが無くても表示できる   |    1/15 | ok  |



#### 機能名:「アカウント検索(5.3.4)」


|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|0文字のニックネームを検索することができる|1/14|OK
|2|10文字のニックネームを検索することができる|1/14|OK
|3|ニックネームに11文字以上を許可しない|1/14|OK|
|4|卒業年度がテキスト入力できる|1/14|OK
|5|半角数字で入力された4桁の卒業年度を検索することができる|1/14|OK
|6|3桁以下の卒業年度を許可しない|1/14|OK
|7|5桁以上の卒業年度を許可しない|1/14|OK
|8|卒業年度に全角/半角スペースを許可しない|1/14|OK||
|9|卒業年度にひらがな/カタカナ/漢字を許可しない|1/14|OK
|10|所属がテキスト入力できる|1/13|OK
|11|20文字の所属を検索することができる|1/14|OK
|12|所属に21文字以上を許可しない|1/14|OK
|13|職種がプルダウンメニューによって選択できる|1/13|OK
|14|性別がプルダウンメニューによって選択できる|1/13|OK
|15|フリースペースがテキスト入力できる|1/13|OK
|16|20文字のフリースペースを登録することができる|1/15|ok
|17|フリースペースに21文字以上を許可しない|  1/15 | ok  |

#### 機能名:「アカウント一覧表示(5.3.5)」


|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|機能が実行できる|1/14|OK
|2|所属が無くても表示できる   |    1/15 | ok  |
|3|職種が無くても表示できる   |    1/15 | ok  |
|4|性別が無くても表示できる   |    1/15 | ok  |
|5|連絡先が無くても表示できる   |    1/15 | ok  |
|6|フリースペースが無くても表示できる   |    1/15 | ok  |
|7  | アカウント未登録者が検索されない  |    1/15 | ok  |
|8   | 学生アカウントが社会人アカウントを参照している  |    1/15 | 両方を検索 |
|9   | 社会人アカウントが学生アカウントを参照している  |    1/15 | 両方を検索  |
