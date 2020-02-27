<script>
  export let name;
  export let status;
  export let tags;
  export let description;
  export let createDttm;
  export let links;
  export let team;
  export let analogs;
  export let techStack;
  export let lookingFor;
</script>

<div class="project">
    <div>name: {name}</div>
    <div>status: {status}</div>
    <div>tags: {tags}</div>
    <div>description: {description}</div>
    <div>createDttm: {createDttm}</div>
    <div>links: {links}</div>
    <div>team: {team}</div>
    <div>analogs: {analogs}</div>
    <div>techStack: {techStack}</div>
    <div>lookingFor: {lookingFor}</div>
</div>

<style>
	div.project {
		padding: 1em;
		margin: 0 auto;
		color: #111111;
		text-align: left;
		text-transform: uppercase;
		font-size: 1em;
    border-width: 1px;
    border-color: black;
    border-style: solid;
	}
</style>