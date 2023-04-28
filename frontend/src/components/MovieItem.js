import React from "react";
import { Link } from "react-router-dom";
import './main.css';

function MovieItem({ movie_id, title, price }) {
    //const url = 'https://upload.wikimedia.org/wikipedia/ko/f/f0/%EC%8A%A4%ED%8C%8C%EC%9D%B4%EB%8D%94%EB%A7%A8_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg';
    const url = `http://localhost:8090/download/${movie_id}`;
    
    let img = '';
    if (url !== '') {
        img = `<img src=${url} width='100px' height='100px'onerror='this.style.display="none"'/>`;//JSX
    } else {
        img = '[영화 이미지 미등록]<br/>';
    }
    return (
        <div style={{ margin: '5px' }}>
            <Link to={`/detail/${movie_id}`}>
                <span dangerouslySetInnerHTML={{ __html: img }}></span><br/>
                {title} <br />
                {price}원 <br /><br />
            </Link>
        </div>
    )
}
export default MovieItem;