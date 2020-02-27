<script>
	import Project from './Project.svelte';
	import {onMount} from 'svelte';

	const project1 = {
		name: 'My Project',
    status: 'Active',
    tags: ['finance', 'open source', 'commerce'],
    description: 'bla bla',
    createDttm: '10/12/2020',
    links: ['https://tuda.shodi.com'],
    team: ['Human j. Developer'],
    analogs: [],
    techStack: 'shocaml, shavascrolls',
    lookingFor: ['frontend developer', 'sales', 'ceo', 'pomadchin']
	}
	const project2 = {
		name: 'Her Project',
    status: 'Active',
    tags: ['finance', 'open source', 'commerce', 'beginner friendly'],
    description: 'Mir nikogda ne budet prezhnim',
    createDttm: '24/12/2020',
    links: ['https://change.world.org'],
    team: ['Catty Purr'],
    analogs: [],
    techStack: 'stoplang, writescrolls',
    lookingFor: ['backend developers', 'pomadchin']
	}

	let projects = [project1, project2];

	onMount(async () => {
		const res = await fetch(`https://pitohui.org`);
		projects = await res.json();
	});
</script>

<main>
	<div class="projects">
		{#each projects as project}
			<Project {...project}/>
		{:else}
			<p>Loading...</p>
		{/each}
	</div>
</main>

<style>
	main, div.projects {
		text-align: center;
		padding: 1em;
		max-width: 1024px;
		margin: 0 auto;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>