package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList=(List<Mutter>)application.getAttribute("mutterList");
		//取得できなかった場合は、リストを新規作成してアプリケーションスコープに保存
		if(mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		
		//ログインしているか確認するため　セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) { //ログインしていない場合
			//リダイレクト
			response.sendRedirect("index.jsp");
		} else { //ログイン済みの場合
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		
		// チェックボックスの選択された値を取得
		String text = request.getParameter("radiobutton");
		//System.out.println(text);
		

		//相手ランダム
		int com =(int)(Math.random()*3)+1;	//1グー、2チョキ、3パー
		
		
		//勝敗判定
				String hand="";
				String play="";
				String COM="";
				
				//ランダム数値をじゃんけんの手へ
				if (com==1) {
					COM = "ＣＯＭ：グー";
				} else if (com==2) {
					COM = "ＣＯＭ：チョキ";
				} else {
					COM = "ＣＯＭ：パー";
				}
				
				if (text.equals("グー")) {
					play = "あなた：グー";
					if(com==2) {
						hand="あなたの勝ち　（" + play + "　"+ COM +"）";
					}else if(com==3) {
						hand="ＣＯＭの勝ち　（" + play + "　"+ COM +"）";
					}else {
						hand = "あいこ　（" + play + "　"+ COM +"）";
					}
				}
				else if (text.equals("チョキ")) {
					play = "あなた：チョキ";
					if(com==3) {
						hand="あなたの勝ち　（" + play + "　"+ COM +"）";
					}else if(com==1) {
						hand="ＣＯＭの勝ち　（" + play + "　"+ COM +"）";
					}else {
						hand = "あいこ　（" + play + "　"+ COM +"）";
					}
				}
				else if (text.equals("パー")) {
					play = "あなた：パー";
					if(com==1) {
						hand="あなたの勝ち　（" + play + "　"+ COM +"）";
					}else if(com==2) {
						hand="ＣＯＭの勝ち　（" + play + "　"+ COM +"）";
					}else {
						hand = "あいこ　（" + play + "　"+ COM +"）";
					}
				}
	
		
				//入力値チェック				
					//アプリケーションスコープに保存されたリストを取得
					ServletContext application = this.getServletContext();
					List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
					
					//セッションスコープに保存されたユーザー情報を取得
					HttpSession session = request.getSession();
					User loginUser = (User)session.getAttribute("loginUser");
					
					//リストに追加
					Mutter mutter = new Mutter(loginUser.getName(), hand);
					PostMutterLogic postMutterLogic = new PostMutterLogic();
					postMutterLogic.execute(mutter, mutterList);
					
					//アプリケーションスコープにリストを保存
					application.setAttribute("mutterList", mutterList);
		
		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
