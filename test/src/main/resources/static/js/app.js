const dataArray = ["\n\nMySQL的事务是一组SQL语句的集合，这些SQL语句要么全部执行成功，要么全部失败回滚。在MySQL中，一个事务是由BEGIN、ROLLBACK和COMMIT语句来控制的。在事务开始之前，应该使用BEGIN语句来开启事务。在执行事务期间，如果任何一个SQL语句执行失败，那么所有的SQL语句都将被回滚。如果所有的SQL语句都执行成功，那么使用COMMIT语句来提交事务。\n\nMySQL的事务有以下特点：\n\n1. 原子性：事务中的所有操作要么全部执行成功，要么全部执行失败回滚。\n\n2. 一致性：事务执行前后，数据的完整性、一致性和正确性保持不变。\n\n3. 隔离性：一个事务的执行不会被其他事务干扰，每个事务都是独立的。\n\n4. 持久性：一旦一个事务提交，其对数据库的修改就是永久性的，即使系统出现故障也不会丢失。\n\n在MySQL中，事务的隔离级别有四种：READ-UNCOMMITTED、READ-COMMITTED、REPEATABLE-READ和SERIALIZABLE。这些隔离级别定义了事务的可见性和并发性。在选择隔离级别时，需要考虑数据一致性和性能的权衡。", "\n\n以下是Java实现快速排序的示例代码：\n\n```\npublic class QuickSort {\n    \n    public static void sort(int[] arr) {\n        if (arr == null || arr.length == 0) {\n            return;\n        }\n        quickSort(arr, 0, arr.length - 1);\n    }\n    \n    private static void quickSort(int[] arr, int left, int right) {\n        int i = left, j = right;\n        int pivot = arr[left + (right - left) / 2];\n        \n        while (i <= j) {\n            while (arr[i] < pivot) {\n                i++;\n            }\n            while (arr[j] > pivot) {\n                j--;\n            }\n            if (i <= j) {\n                int temp = arr[i];\n                arr[i] = arr[j];\n                arr[j] = temp;\n                i++;\n                j--;\n            }\n        }\n        \n        if (left < j) {\n            quickSort(arr, left, j);\n        }\n        if (i < right) {\n            quickSort(arr, i, right);\n        }\n    }\n    \n    public static void main(String[] args) {\n        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};\n        sort(arr);\n        for (int num : arr) {\n            System.out.print(num + \" \");\n        }\n    }\n}\n```\n\n快速排序是一种比较快的排序算法，基本思想是通过选择一个关键字，把待排序的元素分成两组，一组中的元素都比关键字小，另一组中的元素都比关键字大，然后递归地对这两组元素进行排序。其中，关键字的选择可以影响排序的效率，常用的选择方法是取第一个元素、最后一个元素、中间元素或者随机元素作为关键字。在实现过程中，需要使用两个指针i和j，从待排序的数组两端开始遍历，找到需要交换的元素，直到i和j重合。"];
const messageBox = document.getElementById('message-box');
const messageInput = document.getElementById('message-input');
const sendButton = document.getElementById('send-button');
let codeCount = 0;
let leftIndex = 0;

// 发送消息
function sendMessage() {
    // 获取用户输入的消息
    const message = messageInput.value.trim();

    // 如果消息为空，则不发送
    if (!message) return;
    addMessage(message, 'right');
    // 清空输入框
    messageInput.value = '';

    // 向服务器发送请求
    // fetch(`/sendMessage?message=${encodeURIComponent(message)}`)
    //     .then(response => response.text())
    //     .then(reply => {
    //         // 收到回复后添加消息到消息框
    //         addMessage(reply, 'left');
    //     })
    //     .catch(error => {
    //         console.error(error);
    //         alert('Failed to send message.');
    //     });
    // 收到回复后添加消息到消息框(模拟)
    addMessage(dataArray[1], 'left');
}

// 添加消息到消息框
function addMessage(message, align) {
    let codeIdArray = [];
    if (align === 'left') {
        const textarea = document.createElement('textarea');
        var messageArray = message.split("```");
        let messageParam = '';
        for (let i = 0; i < messageArray.length; i++) {
            if (i % 2 === 1) {
                messageArray[i] = "```" + messageArray[i] + "```";
                let messageTemp = marked(messageArray[i]);
                let highlightAuto = hljs.highlightAuto(messageTemp);
                messageTemp = highlightAuto.value;
                textarea.innerHTML = messageTemp;
                let value = textarea.value;
                let index;
                if ((index = value.indexOf('<code>')) > 0) {
                    codeCount++;
                    value = value.replace('<code>', '<div class="code-block-container"><button class="copy-button" id="copy-button' + codeCount + '">复制</button><code id="code' + codeCount + '" class="language-' + highlightAuto.language + '">');
                    value = value.replace('</code>', '</code></div>');
                    codeIdArray.push(codeCount);
                }
                messageArray[i] = value;
            } else {
                messageArray[i] = "<p>" + messageArray[i] + "</p>";
            }
            messageParam += messageArray[i];
        }
        message = messageParam;
    }
    // 创建消息元素并设置样式
    const messageElement = document.createElement('div');
    messageElement.classList.add('message', align);
    messageElement.classList.add('left' + (++leftIndex));
    // 将消息添加到消息框
    messageBox.appendChild(messageElement);
    let intervalId = setInterval(scrollBottom, 500);
    wordToWordRender('.left' + leftIndex, message).then(r => {
        //添加点击事件
        if (align === 'left') {
            addCopyClickEvent(codeIdArray);
        }
        clearInterval(intervalId);
    })
}

//滚动到底部
function scrollBottom() {
    messageBox.scrollTop = messageBox.scrollHeight;
}

// 点击发送按钮或按下Enter键时发送消息
sendButton.addEventListener('click', sendMessage);
messageInput.addEventListener('keydown', event => {
    if (event.key === 'Enter') sendMessage();
});

// 添加复制点击事件
function addCopyClickEvent(codeIdArray) {
    for (const index in codeIdArray) {
        let codeId = codeIdArray[index];
        let copyButton = document.getElementById('copy-button' + codeId);
        if (!copyButton) {
            console.log("无法复制代码块: 找不到dom元素");
            return;
        }
        copyButton.addEventListener("click", () => {
            const codeBlock = document.getElementById("code" + codeId);
            navigator.clipboard.writeText(codeBlock.textContent)
                .then(() => {
                    console.log("代码块已成功复制！");
                })
                .catch((err) => {
                    console.error("无法复制代码块: ", err);
                });
        });
    }
}

//逐字渲染
function wordToWordRender(domMessage, message) {
    return new Promise(resolve => new Typed(domMessage, {
        strings: [
            message
        ],
        typeSpeed: 5, // 每个字符的显示时间间隔
        startDelay: 100, // 延迟 500ms 后开始显示文字
        backDelay: 500, // 文字结束后延迟 500ms 再进行回退
        loop: false, // 是否循环显示，默认为 false
        showCursor: true, // 是否显示光标
        cursorChar: '_', // 光标样式
        onComplete: resolve
    }))
}