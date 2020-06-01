package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	@Before("execution(* *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("メソッド 開始： " + jp.getSignature());
	}
	
	@After("execution(* *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("メソッド 終了： " + jp.getSignature());
	}
}
