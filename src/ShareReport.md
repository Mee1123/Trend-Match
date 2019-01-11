# Share report
ここでは共有事項に関してみんなで記述します.

## 各ページURL
- ログイン画面:/Login

## System.out.println
- みなさんSystem.out.printlnを多用して開発をしていると思います.
- 今回、System.out.printlnの書き方を統一したいと思います.
- 次の書式で書きたいです.
- System.out.println("そのクラス名:[状況補足など]:id=??");
- 書くのは
	- RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Top.jsp");
	- dispatcher.forward(request, response);
- これの前に入れる.

- 無理に変える必要はありませんが,作っている最中に気が向いたらお願いします.

## sessionに入れたもの.
- 書き方:- 入れた関数:入れたページ
- 書き方例: - ユーザーID:ログイン完了ページservlet.user....login.java  みたいな
- userID:LoginServetにて

