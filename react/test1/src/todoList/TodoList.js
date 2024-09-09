import {useState} from 'react';
/*
input 창과 버튼, 리스트를 구성해서 버튼을 클릭하면 input창에 들어간 값이 오늘의 할일에 추가되도록 작성
*/
function TodoList(){
	let [todo, setTodo] = useState("");
	var [todoList, setTodoList] = useState(['등원', '수업', '점심', '수업', '하원']);
	function change(e){
		//가져온 입력값으로 input 스테이트 변수값을 가져옴
		setTodo(e.target.value);
 	}
	function add(){
		alert(todo);
		setTodoList([...todoList, todo]);
	}
	return (
		<div>
			<input onChange={change}/>
			<button onClick={add}>추가</button>
			<ul>
			{
				todoList.map((value)=>{
					return <li>{value}</li> 
				})
		  }
			</ul>
			
		</div>
	)
}

export default TodoList;