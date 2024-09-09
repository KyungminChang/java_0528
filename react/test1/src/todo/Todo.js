import {useState} from 'react';
/*
input창과 버튼, h1태그로 된 화면을 구성
1.state 변수 todo와 setTodo를 선언
2.input 창에 값이 바뀌면 콘솔에 1이 출력되게 작성
3.console창에 1대신에 input창에 읿력된 값이 출력되도록 작성
4.state 변수 tmp와 setTmp를 선언
5.input창에 입력된 값을 state 변수 todo에 업데이트
6.버튼을 클릭하면 콘솔에 2가 출력되게 작성
7.버튼을 클릭하면 state 변수 todo의 값을 tmp의 값으로 업데이트
*/

function Todo() {
	let [todo, setTodo] = useState("");
	let [tmp, setTmp] = useState("");
	function imputChange(e){
		//가져온 입력값으로 input 스테이트 변수값을 가져옴
		setTmp(e.target.value);
		console.log(tmp);
 	}

	function btnClick(){
		alert(2);
		setTodo(tmp);
	}
	return (
		<div>
			<input onChange={imputChange}/>
			<button onClick={btnClick}>버튼</button>
			<h1>{todo}</h1>
		</div>
	)
}

export default Todo;