const Test = () => {

    let sum = 0

    // 오늘 학습한 Promise를 사용해서
    // 현재 20초 가량 소요되는 이 코드의 속도를 높여보자 !
    // (아무런 의미 없이 그냥 오래 걸리는 녀석임)

    for (var i = 1; i <= 100000000; i++) {
        sum += (i * 0.000000001) * Math.sin(i * Math.PI / 180.0)
        sum += (i * 0.00000001) * Math.cos(i * Math.PI / 90.0)
        sum += (i * 0.0000001) * Math.sin(i * Math.PI / 270.0)
        sum += (i * 0.000001) * Math.cos(i * Math.PI / 240.0)
        sum += (i * 0.00001) * Math.sin(i * Math.PI / 360.0)
    }

    console.log(sum)

    return (
        <div className="Test">
            <p>Test</p>
        </div>
    )
}

export default Test

/*
import GeneratorTest from './generator-test/GeneratorTest';
import NonPromiseTest from './promise-asynchronous/NonPromiseTest';
import NonPromiseTest2 from './promise-asynchronous/NonPromiseTest2';
import PromiseTest from './promise-asynchronous/PromiseTest';
import PromiseTest2 from './promise-asynchronous/PromiseTest2';
import PromiseTest3 from './promise-asynchronous/PromiseTest3';
import PromiseTest4 from './promise-asynchronous/PromiseTest4';
import PromiseTest5 from './promise-asynchronous/PromiseTest5';
import PromiseTest6 from './promise-asynchronous/PromiseTest6';
import PromiseTest7 from './promise-asynchronous/PromiseTest7';
import PromiseTest8 from './promise-asynchronous/PromiseTest8';
import PromiseParallelTest from './promise-parallel/PromiseParallelTest';
import PromiseParallelTest2 from './promise-parallel/PromiseParallelTest2';
import PromiseParallelTest3 from './promise-parallel/PromiseParallelTest3';
import PromiseParallelTest4 from './promise-parallel/PromiseParallelTest4';
import PromiseParallelTest5 from './promise-parallel/PromiseParallelTest5';
import PromiseParallelTest6 from './promise-parallel/PromiseParallelTest6';
import PromiseParallelTest7 from './promise-parallel/PromiseParallelTest7';

    <GeneratorTest />
    <NonPromiseTest />
    <NonPromiseTest2 />
    <PromiseTest />
    <PromiseTest2 />
    <PromiseTest3 />
    <PromiseTest4 />
    <PromiseTest5 />
    <PromiseTest6 />
    <PromiseTest7 />
    <PromiseTest8 />
    <PromiseParallelTest />
    <PromiseParallelTest2 />
    <PromiseParallelTest3 />
    <PromiseParallelTest4 />
    <PromiseParallelTest5 />
    <PromiseParallelTest6 />
    <PromiseParallelTest7 />
    */