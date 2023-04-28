import React, {useRef} from "react";
import { useNavigate } from "react-router";
import './main.css';


function WriteMovie() {
    const navigate = useNavigate();
    const title = useRef();
    const price = useRef();
    const synopsis = useRef();
    const img = useRef();

    return (
        <div>
            <h2>영화 등록</h2>
            <table>
                <tboyd>
                    <tr>
                        <td>영화제목</td>
                        <td><input ref={title}></input></td>
                    </tr>
                    
                    <tr>
                        <td>가격</td>
                        <td><input type="number" ref={price}></input></td>
                    </tr>

                    <tr>
                        <td>줄거리</td>
                        <td><textarea rows="5" cols="60"
                         ref={synopsis}></textarea></td>
                    </tr>

                    <tr>
                        <td>이미지</td>
                        <td>
                            <input type="file" ref={img}></input>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan="2" align="center">
                            <button type="button" onClick={() => {
                                const form = new FormData();
                                let jsonBodyData = {
                                    'title': title.current.value,
                                    'price': price.current.value,
                                    'synopsis': synopsis.current.value
                                }
                                form.append('movie', new Blob([JSON.stringify(jsonBodyData)], {
                                    type: 'application/json'
                                }));
                                form.append('img', img.current.files[0]);
                                fetch('/saveMovie', {
                                    method: 'POST',
                                    body: form
                                }).then(() => {
                                    navigate('/');
                                });
                            }}>저장</button>
                            <button type="button" onClick={() => navigate('/')}>목록</button>
                        </td>
                    </tr>

                </tboyd>
            </table>
        </div>
    )

}

export default WriteMovie;