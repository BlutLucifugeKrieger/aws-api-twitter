

const twitterForm = document.getElementById("twitter_form")


twitterForm.addEventListener("submit",(event)=>{

    event.preventDefault()

    const tweetContent = document.getElementById("tweet_text_area").value
    const table_tweets = document.getElementById("table_body")
    const array = {tweetContent}
    const jsonValue = JSON.stringify(array)
    

    fetch("http://localhost:4567/tweets",{

        method:"POST",
        body:jsonValue,
        headers:{

            "Content-Type":"application/json"
        }
    }).then((response)=>{

        if(response.status === 200){

            while (table_tweets.firstChild) {
                table_tweets.removeChild(table_tweets.firstChild);
            }
            
            getTweets()
            return response.json()
        }


    }).catch(() => console.error({errors:"fallo"}))
})




function getTweets(){

    fetch("http://localhost:4567/tweets",{

            method:"GET",
            headers:{

                "Content-Type":"application/json"
            }
        }).then((response)=>{

                return response.json()

        }).then((data)=>{

            data.forEach(element => {
                const tableBody = document.getElementById("table_body");
            
                const row = document.createElement("tr");
            
                const messageCell = document.createElement("td");
                messageCell.textContent = element.tweetContent;
                row.appendChild(messageCell);
            
                const yearCell = document.createElement("td");
                yearCell.textContent = element.date.date.year;
                row.appendChild(yearCell);
            
                const monthCell = document.createElement("td");
                monthCell.textContent = element.date.date.month;
                row.appendChild(monthCell);
            
                const dayCell = document.createElement("td");
                dayCell.textContent = element.date.date.day;
                row.appendChild(dayCell);
            
                const hourCell = document.createElement("td");
                hourCell.textContent = element.date.time.hour;
                row.appendChild(hourCell);

                const minuteCell = document.createElement("td")
                minuteCell.textContent = element.date.time.minute
                row.appendChild(minuteCell)

                const secondCell = document.createElement("td")
                secondCell.textContent = element.date.time.second
                row.appendChild(secondCell)
            
                tableBody.appendChild(row);
            });
            
        })
}



document.addEventListener("DOMContentLoaded",()=>{

    getTweets()
})






