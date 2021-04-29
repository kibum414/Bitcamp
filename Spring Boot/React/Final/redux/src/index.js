import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createStore, combineReducers } from 'redux';
import counterReducer from './counter/reducer/counter.reducer'
import { configureStore } from '@reduxjs/toolkit';
import rtkcounterReducer from './counter/reducer/counter.slice'

const rootReducer = combineReducers({ counterReducer, rtkcounterReducer })
// const store = createStore(rootReducer) : 바닐라 리덕스
const store = configureStore({ reducer: rootReducer }) // RTK

ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </Provider>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
