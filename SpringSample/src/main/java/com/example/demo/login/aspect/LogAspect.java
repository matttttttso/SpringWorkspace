package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	//		"execution(<戻り値> <パッケージ名>.<クラス 名>.<メソッド名>(<引数>)"
	/*
	戻り値：*（アスタリスク）で全ての戻り値を指定しています。
	パッケージ名：「*..*」と指定することで、全てのパッケージが対象となります。
	クラス名：「*Controller」と指定することで、末尾にControllerと付くクラスが対象になります。
	メソッド名：*（アスタリスク）を指定します。
	引数：..（ドット２個）で全ての引数が対象になります。
	*/
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable {
		
		System.out.println("メソッド開始： " + jp.getSignature());

		try {
			Object Result = jp.proceed();
			System.out.println("メソッド終了： " + jp.getSignature());
			return Result;
		} catch(Exception e) {
			System.out.println("メソッド異常終了： " + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

	// UserDaoクラスのログ出力
	@Around("execution(* *..*.*UserDao*.*(..))")
	public Object daoLog(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("メソッド開始： " + jp.getSignature());
		try {
			Object result = jp.proceed();
			System.out.println("メソッド終了： " + jp.getSignature());
			return result;
		} catch (Exception e) {
			System.out.println("メソッド異常終了： " + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}
}
